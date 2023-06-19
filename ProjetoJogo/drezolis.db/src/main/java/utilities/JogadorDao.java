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

        // Comando SQL em String
        String sql = "INSERT INTO jogador (nome, apelido) VALUES (?, ?)";

        // Abertura de conexão
        ConnectionFactory factory = new ConnectionFactory();

        try (Connection c = factory.obtemConexao()) {
            // Pré compilação do comando
            PreparedStatement ps = c.prepareStatement(sql);

            // Preenche os dados faltantes
            ps.setString(1, jogador.getNome());
            ps.setString(2, jogador.getApelido());

            // Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void atualizar(Jogador jogador) {
        //1: Definir o comando SQL
        String sql = "UPDATE jogador SET nome = ?, apelido = ? WHERE id = ?";
        //2: Abrir uma conexao
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            //3: Pre compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, jogador.getNome());
            ps.setString(2, jogador.getApelido());
            ps.setInt(3, jogador.getId());

            //5: Executa o comando
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void apagar(int id) {
        //1: Definir o comando SQL
        String sql = "DELETE FROM jogador WHERE id = ?";
        //2: Abrir uma conexao
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            //3: Pre compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setInt(1, id);
            //5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listar() {
        //1: Definir o comando SQL
        String sql = "SELECT * FROM jogador";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Executa o comando e guarda o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
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

