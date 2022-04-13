package br.com.ecommerce.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Endereco")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EnderecoFK enderecoFK;
	
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
    private EstadoEndereco estadoEndereco; 
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "cod_cliente_pk_fk", referencedColumnName = "codigo")
    private Cliente cliente;
    
    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "endereco_entrega")
    private Set<Pedido> pedidos = new HashSet<>();
	
    public Endereco(String logradouro, int numeroLogradouro, String complemento, 
    		String bairro, String cidade,UF uf, String cep, EstadoEndereco estado) {
		this.logradouro = logradouro;
		this.numeroLogradouro = numeroLogradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.estadoEndereco = estado;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public TipoEndereco getTipo() {
		return tipo;
	}
	public void setTipo(TipoEndereco tipo) {
		this.tipo = tipo;
	}
	
}
