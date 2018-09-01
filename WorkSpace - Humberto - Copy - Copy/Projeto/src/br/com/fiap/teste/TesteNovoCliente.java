package br.com.fiap.teste;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Endereco;
import br.com.fiap.bo.ClienteBO;
import br.com.fiap.excecao.Excecao;

public class TesteNovoCliente {
	
	public static void main(String[] args) {
		
		try {
			System.out.println(ClienteBO.novoCliente(new Cliente(
					JOptionPane.showInputDialog("Nome: "),
					Integer.parseInt(JOptionPane.showInputDialog("Nº")),
					Integer.parseInt(JOptionPane.showInputDialog("Estrelas")),
					new Endereco(
							Integer.parseInt(JOptionPane.showInputDialog("Codigo")),
							JOptionPane.showInputDialog("Logradouro: "),
							JOptionPane.showInputDialog("Numero: "),
							JOptionPane.showInputDialog("CEP: ")
							)
					
					)));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}
}
