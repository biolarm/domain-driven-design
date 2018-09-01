package br.com.fiap.excecao;

public class Excecao {

	public static String tratarExcecao(Exception e) {
		if(e.getClass().getName().equals("java.lang.NumberFormatException")) {
			return "N�mero inv�lido!!!";
		}else if(e.getClass().getName().equals("java.lang.SQLException")){
			return "Erro ao conectar no banco";
		}
		else {
			return "Ocorreu uma falha!";
		}
		
	}
	
}
