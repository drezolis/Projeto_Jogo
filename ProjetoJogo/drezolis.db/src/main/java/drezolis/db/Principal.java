package drezolis.db;

import javax.swing.JOptionPane;

import entities.Jogador;
import utilities.JogadorDao;
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
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 0:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}

		}while (op != 0);
	}

}
