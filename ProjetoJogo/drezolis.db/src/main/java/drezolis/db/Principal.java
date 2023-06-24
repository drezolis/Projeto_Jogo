package drezolis.db;

import javax.swing.JOptionPane;

import entities.Jogador;
import entities.Jogo;
import entities.Pontuacao;
import utilities.JogadorDao;
import utilities.JogoDao;
import utilities.PontuacaoDao;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		JogadorDao jogadorCrud = new JogadorDao();
		JogoDao jogoCrud = new JogoDao();
		PontuacaoDao pontuacaoCrud = new PontuacaoDao();
		String menu = "1 - Cadastrar Jogador\n2 - Atualizar Jogador\n3 - Apagar Jogador\n4 - Listar Jogadores\n5 - Mostrar Jogador\n" +
				"6 - Cadastrar Jogo\n7 - Atualizar Jogo\n8 - Apagar Jogo\n9 - Listar Jogos\n10 - Mostrar Jogo\n11 - Cadastrar Pontuação\n12 - Mostrar Pontuação\n" +
				"0 - Sair";
		int op;
		do{
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op){
			case 1:
				String nomeJogador = JOptionPane.showInputDialog("Nome?");
				String apelidoJogador = JOptionPane.showInputDialog("Apelido?");
				Jogador jogador = new Jogador(nomeJogador, apelidoJogador);
				jogadorCrud.inserir(jogador);
				break;
			case 2:
				nomeJogador = JOptionPane.showInputDialog("Nome?");
				apelidoJogador = JOptionPane.showInputDialog("Apelido?");
				int id = Integer.parseInt(JOptionPane.showInputDialog("Id?"));
				jogador = new Jogador(nomeJogador, apelidoJogador);
				jogador.setNome(nomeJogador);
				jogador.setApelido(apelidoJogador);
				jogador.setId(id);
				jogadorCrud.atualizar(jogador);
				break;
			case 3:
				id = Integer.parseInt(JOptionPane.showInputDialog("ID?"));
				jogadorCrud.apagar(id);
				break;
			case 4:
				List<Jogador> pessoas = new ArrayList<>();
				jogadorCrud.listar();
				for (int index=0;index<pessoas.size();index++) {
					System.out.println(pessoas.get(index).toString());
				}
				break;
			case 5:
				id = Integer.parseInt(JOptionPane.showInputDialog("ID?"));
				jogador = new Jogador();
				jogador = jogadorCrud.mostraPorId(id);
				if (!jogador.getNome().equals("")) {
					System.out.println(jogador);
				}

				break;
			case 6:
				String nomeJogo = JOptionPane.showInputDialog("Nome?");
				String temaJogo = JOptionPane.showInputDialog("Tema?");
				int pontMax = Integer.parseInt(JOptionPane.showInputDialog("Pontuação máxima?"));
				Jogo jogo = new Jogo(nomeJogo, temaJogo, pontMax);
				jogoCrud.inserir(jogo);
				break;
			case 7:
				id = Integer.parseInt(JOptionPane.showInputDialog("Id?"));
				nomeJogo = JOptionPane.showInputDialog("Nome?");
				temaJogo = JOptionPane.showInputDialog("Tema?");
				pontMax = Integer.parseInt(JOptionPane.showInputDialog("Pontuação máxima?"));
				jogo = new Jogo(nomeJogo, temaJogo, pontMax);
				jogo.setNome(nomeJogo);
				jogo.setTema(temaJogo);
				jogo.setId(id);
				jogoCrud.atualizar(jogo);
				break;
			case 8:
				id = Integer.parseInt(JOptionPane.showInputDialog("ID?"));
				jogoCrud.apagar(id);
				break;
			case 9:
				List<Jogo> jogos = new ArrayList<>();
				jogoCrud.listar();
				for (int index=0;index<jogos.size();index++) {
					System.out.println(jogos.get(index).toString());
				}
				break;
			case 10:
				id = Integer.parseInt(JOptionPane.showInputDialog("ID?"));
				jogo = new Jogo();
				jogo = jogoCrud.mostraPorId(id);
				if (jogo != null && !jogo.getNome().equals("")) {
					System.out.println(jogo);
				}

				break;
			case 11:
				int jogadorId = Integer.parseInt(JOptionPane.showInputDialog("ID do Jogador?"));
				int jogoId = Integer.parseInt(JOptionPane.showInputDialog("ID do Jogo?"));
				int pontuacao = Integer.parseInt(JOptionPane.showInputDialog("Pontuação?"));
				jogador = jogadorCrud.mostraPorId(jogadorId);
				jogo = jogoCrud.mostraPorId(jogoId);
				Pontuacao pontuacaoNova;
				if (jogador != null && jogo != null) {
					pontuacaoNova = new Pontuacao(pontuacao, jogador, jogo);
					pontuacaoCrud.inserir(pontuacaoNova);
				}
				break;
			case 12:
				jogadorId = Integer.parseInt(JOptionPane.showInputDialog("ID do Jogador?"));
				jogoId = Integer.parseInt(JOptionPane.showInputDialog("ID do Jogo?"));
				jogador = jogadorCrud.mostraPorId(jogadorId);
				jogo = jogoCrud.mostraPorId(jogoId);
				if (jogador != null && jogo != null) {
					pontuacaoNova = pontuacaoCrud.mostrarPontuacao(jogador, jogo);
					System.out.println(pontuacaoNova);
				}
				break;
			case 0:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}

		}while (op != 0);
	}

}
