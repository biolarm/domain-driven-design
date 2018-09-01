package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Endereco;
import br.com.fiap.conexao.Conexao;

public class EnderecoDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public EnderecoDAO() throws Exception {
		con = Conexao.conectar();
	}
	
	public String gravar(Endereco obj)throws Exception {
		stmt = con.prepareStatement
				("INSERT INTO T_DDD_ENDERECO (CD_ENDERECO, DS_LOGRADOURO, NR_ENDERECO, NR_CEP) VALUES(?,?,?,?)");
		stmt.setInt(1,obj.getCodigo());
		stmt.setString(2,obj.getLogradouro());
		stmt.setString(3, obj.getNumero());
		stmt.setString(4, obj.getCep());
		
		stmt.executeUpdate();
		
		return "Endereço cadastrado!";
	}
	
	public Endereco consultarPorCodigo(int codigo) throws Exception{
		stmt = con.prepareStatement
				("SELECT * FROM T_DDD_ENDERECO WHERE CD_ENDERECO = ?");
		stmt.setInt(1, codigo);
		
		rs = stmt.executeQuery();
		
		Endereco endereco = new Endereco();
		if(rs.next()) {
			endereco.setCodigo(rs.getInt("CD_ENDERECO"));
			endereco.setLogradouro(rs.getString("DS_LOGRADOURO"));
			endereco.setNumero(rs.getString("NR_ENDERECO"));
			endereco.setCep(rs.getString("NR_CEP"));
		}
		return endereco;
		
	}
	
	public void fechar() throws Exception{
		con.close();
	}
	
}
