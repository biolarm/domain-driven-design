package br.com.fiap.excecao;

public class Excecao extends Exception {
	
	public static String tratarExcecao(Exception e) {
		if(e.getClass().getName().equals("java.lang.NumberFormatException")) {
			return "N�mero inv�lido!!!";
		}else {
			return "Ocorreu um falha!";
		}
		
	}
	
}
