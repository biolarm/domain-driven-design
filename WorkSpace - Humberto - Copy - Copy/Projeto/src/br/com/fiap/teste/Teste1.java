package br.com.fiap.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.fiap.excecao.Excecao;

public class Teste1 {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM81721", "fiap#2018");
			stmt = con.createStatement();
			int intNumero = Integer.parseInt(JOptionPane.showInputDialog("Número: "));
			String strNome=JOptionPane.showInputDialog("Digite o nome: ");
			rs = stmt.executeQuery
					("select * from T_DDD_CLIENTE where NR_CLIENTE="+intNumero+" and NM_CLIENTE='"+strNome+"'");
			if(rs.next()) {
				System.out.println("Logado com sucesso....");
				System.out.println("");
				System.out.println("Nome....:"+rs.getString("NM_CLIENTE"));	
				System.out.println("Numero..: "+rs.getInt("NR_CLIENTE"));
				System.out.println("Estrelas: "+rs.getInt("QT_ESTRELAS"));
				System.out.println("");
			}else {
				System.out.println("login não foi efetuado!!!");
			}
			System.out.println("Abriu...");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(Excecao.tratarExcecao(e));
			}
			
		}
	
	}

}
