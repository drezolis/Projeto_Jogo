package utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;

import drezolis.db.ConnectionFactory;
import entities.Jogo;

public class JogoDao {
	
	public void inserir(Jogo jogo) {
		String sql = "INSERT INTO jogo(nome, tema, pontuacao) VALUES (?, ?, ?)";
		
		ConnectionFactory factory = new ConnectionFactory();
		
		try (Connection c = factory.obtemConexao()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, jogo.getNome());
			ps.setString(2, jogo.getTema());
			ps.setInt(3, jogo.getPontMax());

			ps.execute();
		}
		catch (Exception e){
			e.printStackTrace();
		}

		
	}
	
	public void atualizar() {
		
	}
	
	
}
