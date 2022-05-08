package br.com.ecommerce.service;

import java.util.List;

import br.com.ecommerce.model.Cliente;

public interface IClienteService {
	Cliente getClienteByCpf(String cpf);
	Cliente getClienteByCodigo(Integer codigo);
	List<Cliente> getClienteByNome(String nome);
	List<Cliente> getAllClientes();
	String getNomeByCodigo(Integer codigo);
	Cliente addCliente(Cliente Cliente);
	Cliente updateCliente(Cliente Cliente);
	void deleteCliente(Integer codigo);	
}
