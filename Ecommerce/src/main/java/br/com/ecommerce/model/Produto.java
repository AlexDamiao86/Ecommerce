package br.com.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity	
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer codigo;
	
	@Column(nullable = false, length = 120)
	public String nome; 
	
	@Column(nullable = false, precision = 7, scale = 2)
	public BigDecimal preco;
	

	@Column(nullable = false)
	public Integer quantidade_estoque; 

	
	public Produto(Integer codigo, String nome, BigDecimal preco, Integer quantidade_estoque) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.quantidade_estoque = quantidade_estoque;
	}
	
	public Produto() {
		super();
	}
	public Integer getCodigo() {
		return this.codigo;
	}


	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public Integer getQuantidade_estoque() {
		return quantidade_estoque;
	}
	
	public void setQuantidade_estoque(Integer quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
	return "\nProduto (codigo: " + codigo + 
			", nome: " + nome +
			", preco: " + preco +
			", estoque: " + quantidade_estoque + ")";
	}

}
