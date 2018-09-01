package br.com.fiap.beans;

public class Cliente {
	private String nome;
	private int numero;
	private int qtdeEstrelas;
	private Endereco endereco;
	

	public Cliente() {
		super();
	}

	public Cliente(String nome, int numero, int qtdeEstrelas, Endereco endereco) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.qtdeEstrelas = qtdeEstrelas;
		this.endereco = endereco; 
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getQtdeEstrelas() {
		return qtdeEstrelas;
	}
	public void setQtdeEstrelas(int qtdeEstrelas) {
		this.qtdeEstrelas = qtdeEstrelas;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
}
