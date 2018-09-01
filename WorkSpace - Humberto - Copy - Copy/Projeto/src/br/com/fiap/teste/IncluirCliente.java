package br.com.fiap.teste;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Cliente;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.excecao.Excecao;

public class IncluirCliente {

	public static void main(String[] args) {
		try {
			ClienteDAO dao = new ClienteDAO();
			Cliente cliente = new Cliente();
			cliente.setNome(JOptionPane.showInputDialog("Nome: "));
			cliente.setNumero(Integer.parseInt(JOptionPane.showInputDialog("N�mero")));
			cliente.setQtdeEstrelas(Integer.parseInt(JOptionPane.showInputDialog("Estrelas: ")));
			System.out.println(dao.gravar(cliente));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}finally {
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(Excecao.tratarExcecao(e));
			}
		}

	}

}
