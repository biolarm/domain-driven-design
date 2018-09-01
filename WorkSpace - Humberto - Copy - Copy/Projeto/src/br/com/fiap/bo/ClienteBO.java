package br.com.fiap.bo;

import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EnderecoDAO;
/**
 * Respons�vel por todas as regras de neg�cio e padriniza��es do Cliente (descricao da classe)
 * 1�) O nome n�o pode conter mais que 40 caracteres
 * 2�) A quantidade de estrelas deve estar entre 1 e 5
 * 3�) O n�mero do cliente n�o pode ser duplicado
 * 
 * @author Fabiola Rodrigues Martins - frm
 * @version 1.0
 * @since 1.0
 * @see br.com.fiap.dao.ClienteDAO
 * @see br.com.fiap.beans.Cliente
 *
 */
public class ClienteBO {
	/**
	 * Este m�todo ir� repassar o objeto cliente para a classe ClienteDAO.
	 * @param cli Este par�metro representa um objeto do Beans
	 * @return O m�todo retorna uma string com mensagemm de sucesso
	 * @throws Exception Tratando a exce��o checked SQLExpception
	 * @author fmr
	 */
	public static String novoCliente(Cliente cli) throws Exception {
		// valida��o
		if (cli.getNome().length()>40) {
			return "Nome Inv�lido";
		}
		
		if(cli.getEndereco()==null) {
			return "Endere�o vazio!";
		}
		
		
		//regra de neg�cio
		if(cli.getQtdeEstrelas()<1 || cli.getQtdeEstrelas()>5) {
			return "Qtde de estrelas inv�lidas";
		}
		//padroniza��o
		cli.setNome(cli.getNome().toUpperCase());
		
		ClienteDAO dao = new ClienteDAO();
		Cliente resultado = dao.pesquisarPorNumero(cli.getNumero());
		if(resultado.getNumero()>0) {
			dao.fechar();
			return "Cliente j� existente";
		} 
		
		//ENDERECO
		String resposta = EnderecoBO.novoEndereco(cli.getEndereco());
		if(resposta.equals("Gravado")) {
			return resposta;
		}
		//FIM ENDERECO
		
		String x = dao.gravar(cli);
		dao.fechar();
		return x;

	}
}
