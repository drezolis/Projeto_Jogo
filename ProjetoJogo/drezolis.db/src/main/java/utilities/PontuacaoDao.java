package utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import drezolis.db.ConnectionFactory;
import entities.Jogador;
import entities.Jogo;
import entities.Pontuacao;

public class PontuacaoDao {
    public void inserir(Pontuacao pontuacao) {
        String sql = "INSERT INTO pontuacao (jogadorId, jogoId, pontuacao) VALUES (?, ?, ?)";

        ConnectionFactory factory = new ConnectionFactory();

        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, pontuacao.getJogador().getId());
            ps.setInt(2, pontuacao.getJogo().getId());
            ps.setInt(3, pontuacao.getPontuacao());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pontuacao mostrarPontuacao(Jogador jogador, Jogo jogo) {
        String sql = "SELECT * FROM pontuacao WHERE jogadorId = ? AND jogoId = ?";

        ConnectionFactory factory = new ConnectionFactory();

        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, jogador.getId());
            ps.setInt(2, jogo.getId());
            ps.execute();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                int pont = rs.getInt("pontuacao");
                Pontuacao pontuacao = new Pontuacao(pont, jogador, jogo);
                pontuacao.setId(id);
                return pontuacao;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}