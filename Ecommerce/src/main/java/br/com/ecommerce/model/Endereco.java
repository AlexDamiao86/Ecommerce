package br.com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity	
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEndereco;
	private TipoEndereco tipo;
	@Column(nullable = false, length = 100)
	private String logradouro;
	private int numeroLogradouro;
	@Column(nullable = true, length = 60)
	private String complemento;
	@Column(nullable = false, length = 60)
	private String bairro;
	@Column(nullable = false, length = 60)
	private String cidade;
	private UF uf;
	@Column(nullable = false, length = 10)
	private String cep;
	
	private Integer getIdEndereco() {
		return idEndereco;
	}
	private void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	private String getLogradouro() {
		return logradouro;
	}
	private void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	private TipoEndereco getTipo() {
		return tipo;
	}
	private void setTipo(TipoEndereco tipo) {
		this.tipo = tipo;
	}
	
}
