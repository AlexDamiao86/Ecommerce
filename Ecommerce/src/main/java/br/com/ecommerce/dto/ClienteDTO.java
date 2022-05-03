package br.com.ecommerce.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import br.com.ecommerce.model.Cliente;
import br.com.ecommerce.model.Endereco;

public class ClienteDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String nome; 
	private String cpf;
	private String email;
	private Date dataNascimento;
	private Set<EnderecoDTO> enderecos = new LinkedHashSet<EnderecoDTO>();	
	private Set<PedidoDTO> pedidos = new LinkedHashSet<PedidoDTO>();
	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(Cliente cliente) {
		this.setCodigo(cliente.getCodigo());
		this.setNome(cliente.getNome());
		this.setCpf(cliente.getCpf());
		this.setEmail(cliente.getEmail());
		this.setDataNascimento(cliente.getDataNascimento());
		for (Endereco e: cliente.getEnderecos()) {
			this.getEnderecos().add(e.toDTO());
		}
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Set<EnderecoDTO> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<EnderecoDTO> enderecos) {
		this.enderecos = enderecos;
	}

}
