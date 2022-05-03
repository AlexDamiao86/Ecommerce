package br.com.ecommerce.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.ecommerce.model.Endereco;
import br.com.ecommerce.model.EstadoEndereco;
import br.com.ecommerce.model.Pedido;
import br.com.ecommerce.model.TipoEndereco;
import br.com.ecommerce.model.UF;


public class EnderecoDTO implements Serializable{
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idEndereco;
	private TipoEndereco tipo;
	private String logradouro;
	private int numeroLogradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private UF uf;
	private String cep;
    private EstadoEndereco estadoEndereco; 
    private Set<PedidoDTO> pedidos = new HashSet<>();

	private ClienteDTO cliente;
    
    
    public EnderecoDTO(Endereco endereco) {
		this.setIdEndereco(endereco.getIdEndereco());
		this.setTipo(endereco.getTipo());
		this.setLogradouro(endereco.getLogradouro());
		this.setNumeroLogradouro(endereco.getNumeroLogradouro());
		this.setComplemento(endereco.getComplemento());
		this.setBairro(endereco.getBairro());
		this.setCidade(endereco.getCidade());
		this.setUf(endereco.getUf());
		this.cep = endereco.getCep();
		this.estadoEndereco = endereco.getEstadoEndereco();
		for (Pedido pedido: endereco.getPedidos()) {
			this.pedidos.add(pedido.toDTO());
		}
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
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

	public String getBairro() {
		return bairro;
	}

	private void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	private void setCidade(String cidade) {
		this.cidade = cidade;
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

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	
}
