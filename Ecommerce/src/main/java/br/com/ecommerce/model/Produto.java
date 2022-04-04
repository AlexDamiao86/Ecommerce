package br.com.ecommerce.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity	
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer codigo;
	
	@Column(nullable = false, length = 120)
	public String nome; 
	
	@Column(nullable = false, precision = 7, scale = 2)
	public BigDecimal preco;
	
	@Column(nullable = false)
	public Integer quantidade_estoque; 
	
	@Override
	public String toString() {
	return "\nProduto (codigo: " + codigo + 
			", nome: " + nome +
			", preco: " + preco +
			", estoque: " + quantidade_estoque + ")";
	}

}
