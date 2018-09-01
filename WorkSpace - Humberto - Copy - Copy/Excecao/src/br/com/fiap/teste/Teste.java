package br.com.fiap.teste;

import javax.swing.JOptionPane;

import br.com.fiap.excecao.Excecao;

public class Teste {
	
	public static void main(String[] args) {
		try {
			int x =Integer.parseInt(JOptionPane.showInputDialog("Digite um número"));		
		
		}catch(Exception e) {
			//e.printStackTrace();
			//Excecao ex = new Excecao();
			//ex.tratarExcecao(e);
			System.out.println(Excecao.tratarExcecao(e)); 
		}finally {
			System.out.println("Até logo...");
		}
	
	
	}

}
