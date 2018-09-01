package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Cliente;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.excecao.Excecao;

public class PesquisarPorNome {
	public static void main(String[] args) {
		
		try {
			ClienteDAO dao= new ClienteDAO();
			List<Cliente> lista = new ArrayList<>();
			do {
				lista = dao.pesquisaPorNome(JOptionPane.showInputDialog("Digite o nome:"));
				for (Cliente c : lista) {
					System.out.println("Nome.....: "+ c.getNome());
					System.out.println("Numeros..: "+ c.getNumero());
					System.out.println("Estrelas.: "+ c.getQtdeEstrelas());				
				}
			} while (JOptionPane.showConfirmDialog(
					null,
					"Continuar?",
					"Título",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE
					)==0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}finally {
			
		}
		
	}
}
