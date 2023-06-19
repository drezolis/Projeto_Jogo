package drezolis.db;

import javax.swing.JOptionPane;

import entities.Jogador;
import utilities.JogadorDao;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		JogadorDao cadastro = new JogadorDao();
		String menu = "1 - Cadastrar\n2 - Atualizar\n3 - Apagar\n4 - Listar\n5 - Mostrar Um\n0 - Sair";
		int op;
		do{
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op){
			case 1:
				String nome = JOptionPane.showInputDialog("Nome?");
				String apelido = JOptionPane.showInputDialog("Apelido?");
				Jogador p = new Jogador(nome, apelido);
				cadastro.inserir(p);
				break;
			case 2:
				nome = JOptionPane.showInputDialog("Nome?");
				apelido = JOptionPane.showInputDialog("Apelido?");
				int id = Integer.parseInt(JOptionPane.showInputDialog("Id?"));
				p = new Jogador(nome, apelido);
				p.setNome(nome);
				p.setApelido(apelido);
				p.setId(id);
				cadastro.atualizar(p);
				break;
			case 3:
				id = Integer.parseInt(JOptionPane.showInputDialog("ID?"));
				cadastro.apagar(id);
				break;
			case 4:
				List<Jogador> pessoas = new ArrayList<>();
				cadastro.listar();
				for (int index=0;index<pessoas.size();index++) {
					System.out.println(pessoas.get(index).toString());
				}
				break;
			case 5:
				id = Integer.parseInt(JOptionPane.showInputDialog("ID?"));
				p = new Jogador();
				p = cadastro.mostraPorId(id);
				if (!p.getNome().equals("")) {
					System.out.println(p);
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
