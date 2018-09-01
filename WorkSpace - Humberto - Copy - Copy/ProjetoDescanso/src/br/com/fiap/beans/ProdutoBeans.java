package br.com.fiap.beans;

public class ProdutoBeans {
	private int codigoProduto;
	private String produto;
	private double valor;
	
	public ProdutoBeans() {
		super();
	}
	public ProdutoBeans(int codigoProduto, String produto, double valor) {
		super();
		this.codigoProduto = codigoProduto;
		this.produto = produto;
		this.valor = valor;
	}
	public int getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	

}
