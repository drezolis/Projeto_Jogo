package drezolis.db;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		PessoaDao servico = new PessoaDao();
		String menu = "1-Cadastrar\n2-Atualizar\n3-Apagar\n4-Listar\n5-Mostrar Um\n0-Sair";
		int op;
		do{
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op){
			case 1:
				String nome = JOptionPane.showInputDialog("Nome?");
				String telefone = JOptionPane.showInputDialog("Telefone?");
			  	String email = JOptionPane.showInputDialog("Email?");
			   	Pessoa p = new Pessoa(nome, telefone, email);
			 	servico.inserir(p);
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
