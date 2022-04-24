package br.com.ecommerce.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Endereco")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EnderecoPK enderecoPK;
	
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
    
    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "endereco_entrega")
    private Set<Pedido> pedidos = new HashSet<>();
	
    public Endereco() {
    	
    }
    
    public Endereco(EnderecoPK end,String logradouro, int numeroLogradouro, String complemento, 
    		String bairro, String cidade,UF uf, String cep, EstadoEndereco estado, TipoEndereco tipo) {
    	this.setEnderecoPK(end);
		this.setLogradouro(logradouro);
		this.setNumeroLogradouro(numeroLogradouro);
		this.setComplemento(complemento);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setUf(uf);
		this.setCep(cep);
		this.setEstadoEndereco(estado);
		this.setTipo(tipo);
	}
    
    public Endereco(String logradouro, int numeroLogradouro, String complemento, 
    		String bairro, String cidade,UF uf, String cep, EstadoEndereco estado) {
		this.setLogradouro(logradouro);
		this.setNumeroLogradouro(numeroLogradouro);
		this.setComplemento(complemento);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setUf(uf);
		this.setCep(cep);
		this.setEstadoEndereco(estado);
	}

	public TipoEndereco getTipo() {
		return tipo;
	}

	public void setTipo(TipoEndereco tipo) {
		this.tipo = tipo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(int numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public EnderecoPK getEnderecoPK() {
		return enderecoPK;
	}

	public void setEnderecoPK(EnderecoPK enderecoPK) {
		this.enderecoPK = enderecoPK;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public EstadoEndereco getEstadoEndereco() {
		return estadoEndereco;
	}

	public void setEstadoEndereco(EstadoEndereco estadoEndereco) {
		this.estadoEndereco = estadoEndereco;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
