package br.com.ecommerce.service;

import java.util.List;

import br.com.ecommerce.model.Cliente;

public interface IClienteService {
	Cliente getClienteByCpf(String cpf);
	List<Cliente> getClienteByNome(String nome);
	String getNomeByCodigo(Integer codigo);
	Cliente addCliente(Cliente Cliente);
	Cliente updateCliente(Cliente Cliente);	
}
