package br.com.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EnderecoPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEND")
	private Long idEndereco;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "cod_cliente_pk_fk", referencedColumnName = "codigo")
    private Cliente cliente;
	
	public EnderecoPK() {
		
	}
	
	
	public Long getIdEndereco() {
		return idEndereco;
	}
	
	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}
	
	public void setCliente(Cliente c) {
		this.cliente = c;
	}
	
}
