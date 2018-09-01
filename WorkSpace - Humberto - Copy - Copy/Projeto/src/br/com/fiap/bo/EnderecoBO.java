package br.com.fiap.bo;

import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.EnderecoDAO;

public class EnderecoBO {

	public static String novoEndereco(Endereco e) throws Exception{
		
		//validação
		if(e.getCep().length()!=9) {
			return "CPF inválido";
		}
		
		if(e.getLogradouro().length() >50) {
			return "Logradouro muito longo";
		}
		
		e.setLogradouro(e.getLogradouro().toUpperCase());
		e.setNumero(e.getNumero().toUpperCase());
		
		
		EnderecoDAO daoEndereco = new EnderecoDAO();
		Endereco ende = daoEndereco.consultarPorCodigo(e.getCodigo());
		//SE NAO EXISTIR ENDERECO, MANDA GRAVAR
		if(e.getCodigo() == 0) {
			daoEndereco.gravar(e);
		}
		daoEndereco.fechar();
		return"Gravado";
		
		
	}
}
