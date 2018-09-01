package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Endereco;
import br.com.fiap.conexao.Conexao;
/**
 * Classe responsável por manipular a tabela T_DDD_CLIENTE.
 * @author Fabiola Rodrigues Martins - frm
 *@version 1.0
 *@since 1.0
 *@see br.com.fiap.beans.Cliente
 *@see br.com.fiap.bo.ClienteBO
 */
public class ClienteDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	/**
	 * Construtor responsável por abrir a conexão
	 * @throws Exception Exceção checked SQLException
	 * @author Fabiola Rodrigues Martins
	 */
	
	//Abrindo a conexao
	public ClienteDAO() throws Exception{
		con=Conexao.conectar();
	}
	/**
	 * Adiciona uma tupla na tabela por abrir a conexão
	 * @param obj Recebe um objeto Cliente beans
	 * @return retorna uma String de operação com sucesso
	 * @throws Exception Exceção checked SQLException
	 * @author Fabiola Rodrigues Martins
	 */
	public String gravar(Cliente obj) throws Exception{
		stmt = con.prepareStatement
				("INSERT INTO T_DDD_CLIENTE (NM_CLIENTE, NR_CLIENTE, QT_ESTRELAS) VALUES (?,?,?)");
		stmt.setString(1, obj.getNome());
		stmt.setInt(2, obj.getNumero());
		stmt.setInt(3, obj.getQtdeEstrelas());
		stmt.setInt(4,obj.getEndereco().getCodigo());
		stmt.executeUpdate();
		return "Gravado com sucesso!!";
	}
	public Cliente pesquisarPorNumero(int valor) throws Exception{
		stmt = con.prepareStatement
				("select * from T_DDD_CLIENTE INNER JOIN T_DDD_ENDERECO ON(FK_ENDERECO = CD_ENDERECO)WHERE NR_CLIETE=?");
		stmt.setInt(1, valor);
		rs = stmt.executeQuery();
		Cliente cliente = new Cliente();
		if (rs.next()) {
			cliente.setNome(rs.getString("NM_CLIENTE"));
			cliente.setNumero(rs.getInt("NR_CLIENTE"));
			cliente.setQtdeEstrelas(rs.getInt("QT_CLIENTE"));
			cliente.setEndereco(new Endereco(
					rs.getInt("CD_ENDERECO"),
					rs.getString("DS_LOGRADOURO"),
					rs.getString("NR_ENDERECO"),
					rs.getString("NR_CEP")
					));
		}
		return cliente;
	}
	
	public List<Cliente> pesquisaPorNome(String nome) throws Exception {
		List<Cliente> lista = new ArrayList<Cliente>();
		stmt = con.prepareStatement("SELECT * FROM T_DDD_CLIENTE INNER JOIN T_DDD_ENDERECO ON(FK_ENDERECO = CD_ENDERECO) WHERE NM_CLIENTE LIKE ?");
		stmt.setString(1, "%" + nome + "%");
		rs = null;
		rs = stmt.executeQuery();
		while(rs.next()) {
			lista.add(new Cliente(
					rs.getString("NM_CLIENTE"), 
					rs.getInt("NR_CLIENTE"),
					rs.getInt("QT_ESTRELAS"),
					new Endereco(
							rs.getInt("CD_ENDERECO"),
							rs.getString("DS_LOGRADOURO"),
							rs.getString("NR_ENDERECO"),
							rs.getString("NR_CEP")
							)
					)); 
		}
		return lista;
	}
	
	public int apagar(int numero) throws Exception{
		stmt = con.prepareStatement
				("DELETE FROM T_DDD_CLIENTE WHERE NR_CLIENTE=?");
		stmt.setInt(1, numero);
		return stmt.executeUpdate();
	}
	
	public int promover(int numero) throws Exception {
		stmt=con.prepareStatement
				("UPDATE T_DDD_CLIENTE SET QT_ESTRELAS=QT_ESTRELAS + 1 WHERE NR_CLIENTE=?");
		stmt.setInt(1, numero);
		return stmt.executeUpdate(); 
	}
	
	public void fechar() throws Exception{
		con.close();
	}

	
	
}






































