package utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import drezolis.db.ConnectionFactory;
import entities.Jogador;
import entities.Jogo;

public class JogoDao {

    public void inserir(Jogo jogo) {
        String sql = "INSERT INTO jogo(nome, tema, pontuacao) VALUES (?, ?, ?)";

        ConnectionFactory factory = new ConnectionFactory();

        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, jogo.getNome());
            ps.setString(2, jogo.getTema());
            ps.setInt(3, jogo.getPontMax());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void atualizar(Jogo jogo) {
        String sql = "UPDATE jogo SET nome = ?, tema = ?, pontuacao = ? WHERE id = ?";

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, jogo.getNome());
            ps.setString(2, jogo.getTema());
            ps.setInt(3, jogo.getPontMax());
            ps.setInt(4, jogo.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void apagar(int id) {

        String sql = "DELETE FROM jogo WHERE id = ?";

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, id);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listar() {

        String sql = "SELECT * FROM jogo";

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {

            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String tema = rs.getString("tema");
                String pontMax = rs.getString("pontuacao");
                String aux = String.format(
                        "ID: %d, Nome: %s, Tema: %s, Pontuação: %s",
                        id,
                        nome,
                        tema,
                        pontMax
                );
                System.out.println(aux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Jogo mostraPorId(int id) {
        String sql = "SELECT * FROM jogo WHERE id = ?;";
        String nome = "";
        String tema = "";

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nome = rs.getString("nome");
                tema = rs.getString("tema");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Jogo jogo = new Jogo();
        jogo.setId(id);
        jogo.setNome(nome);
        jogo.setTema(tema);
        return jogo;
    }
}

	
	

