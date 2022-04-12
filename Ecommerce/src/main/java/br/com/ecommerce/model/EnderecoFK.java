package br.com.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class EnderecoFK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQEND")
	private Integer idEndereco;
	private Integer codCliente;
	
	public EnderecoFK(Integer codCliente,Integer idEndereco) {
		this.codCliente = codCliente;
		this.idEndereco = idEndereco;
	}
	
	public Integer getIdEndereco() {
		return idEndereco;
	}
	
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	
	public Integer getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}
	
}
