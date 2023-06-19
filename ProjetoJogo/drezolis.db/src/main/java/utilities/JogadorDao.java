package utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;

import drezolis.db.ConnectionFactory;
import entities.Jogador;

public class JogadorDao {
      public void inserir (Jogador jogador) {

            // Comando SQL em String
            String sql = "INSERT INTO jogador(nome, apelido) VALUES (?, ?)";

            // Abertura de conexão
            ConnectionFactory factory = new ConnectionFactory();

            try (Connection c = factory.obtemConexao()) {
                  // Pré compilação do comando
                  PreparedStatement ps = c.prepareStatement(sql);

                  // Preenche os dados faltantes
                  ps.setString(1, jogador.getNome());
                  ps.setString(1, jogador.getApelido());

                  // Executa o comando
                  ps.execute();
            } catch (Exception e) {
                  e.printStackTrace();
            }

      }
}
