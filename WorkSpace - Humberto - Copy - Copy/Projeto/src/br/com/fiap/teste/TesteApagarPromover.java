package br.com.fiap.teste;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Cliente;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.excecao.Excecao;

public class TesteApagarPromover {

	public static void main(String[] args) {
		
		try {
			ClienteDAO dao = new ClienteDAO();
			int numero = Integer.parseInt(JOptionPane.showInputDialog
					("Digite o n�mero"));
			char opcao = JOptionPane.showInputDialog
					("Digite <A> para apagar ou <P> para promover").toUpperCase().charAt(0);
			if(opcao=='A') {
				System.out.println("Resultado: " + dao.apagar(numero));
			}else if(opcao == 'P') {
				System.out.println("Resultado: " + dao.promover(numero));
			}else {
				System.out.println("Opc�o Inv�lida!!!");
			}
			dao.fechar();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}
}
