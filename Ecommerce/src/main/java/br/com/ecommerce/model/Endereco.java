package br.com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity	
public class Endereco {
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
    private EstadoEndereco estadodoEndereco; 
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="clientes")
    private List<Cliente> funcionarios = new ArrayList<Cliente>();
    @OneToOne(fetch=FetchType.LAZY, mappedBy="pedidos")
    private Pedido pedido;
	
    public Endereco(String logradouro, int numeroLogradouro, String complemento, 
    		String bairro, String cidade,UF uf, String cep, EstadoEndereco estado) {
		this.logradouro = logradouro;
		this.numeroLogradouro = numeroLogradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.estadodoEndereco = estado;
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
