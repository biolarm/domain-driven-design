package br.com.fiap.bo;

import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EnderecoDAO;
/**
 * Responsável por todas as regras de negócio e padrinizações do Cliente (descricao da classe)
 * 1º) O nome não pode conter mais que 40 caracteres
 * 2º) A quantidade de estrelas deve estar entre 1 e 5
 * 3º) O número do cliente não pode ser duplicado
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
	 * Este método irá repassar o objeto cliente para a classe ClienteDAO.
	 * @param cli Este parâmetro representa um objeto do Beans
	 * @return O método retorna uma string com mensagemm de sucesso
	 * @throws Exception Tratando a exceção checked SQLExpception
	 * @author fmr
	 */
	public static String novoCliente(Cliente cli) throws Exception {
		// validação
		if (cli.getNome().length()>40) {
			return "Nome Inválido";
		}
		
		if(cli.getEndereco()==null) {
			return "Endereço vazio!";
		}
		
		
		//regra de negócio
		if(cli.getQtdeEstrelas()<1 || cli.getQtdeEstrelas()>5) {
			return "Qtde de estrelas inválidas";
		}
		//padronização
		cli.setNome(cli.getNome().toUpperCase());
		
		ClienteDAO dao = new ClienteDAO();
		Cliente resultado = dao.pesquisarPorNumero(cli.getNumero());
		if(resultado.getNumero()>0) {
			dao.fechar();
			return "Cliente já existente";
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
