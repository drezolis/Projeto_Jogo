package utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import drezolis.db.ConnectionFactory;
import entities.Jogador;

import javax.swing.*;

public class JogadorDao {
    public void inserir(Jogador jogador) {
        String sql = "INSERT INTO jogador (nome, apelido) VALUES (?, ?)";

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, jogador.getNome());
            ps.setString(2, jogador.getApelido());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void atualizar(Jogador jogador) {
        String sql = "UPDATE jogador SET nome = ?, apelido = ? WHERE id = ?";

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, jogador.getNome());
            ps.setString(2, jogador.getApelido());
            ps.setInt(3, jogador.getId());

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void apagar(int id) {
        String sql = "DELETE FROM jogador WHERE id = ?";

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
        String sql = "SELECT * FROM jogador";

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String apelido = rs.getString("apelido");
                String aux = String.format(
                        "ID: %d, Nome: %s, Apelido: %s",
                        id,
                        nome,
                        apelido
                );
                System.out.println(aux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Jogador mostraPorId(int id) {
        String sql = "SELECT * FROM jogador WHERE id = ?;";
        String nome = "";
        String apelido = "";

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();
            nome = rs.getString("nome");
            apelido = rs.getString("apelido");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Jogador pessoa = new Jogador(nome, apelido);
        pessoa.setId(id);
        return pessoa;
    }
}

