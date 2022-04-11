package br.com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.ecommerce.model.Cliente;
import br.com.ecommerce.repository.ClienteRepository;


@Service
public class ClienteService implements IClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override		
	public Cliente getClienteByCpf(String cpf) {
		System.out.println("getClienteByCpf()");		
		return clienteRepository.findByCpf(cpf);
	}
	
	@Override
	public List<Cliente> getClienteByNome(String nome) {
		System.out.println("getClienteByNome()");
		return clienteRepository.findByNome(nome);
	}
	
	@Override
	@Cacheable(value= "NomeCliente", key= "#codigo")	
	public String getNomeByCodigo(Integer codigo) {
		System.out.println("getNomeClienteByCodigo");
		return clienteRepository.findByCodigo(codigo);
	}
	
    @Override
	public Cliente addCliente(Cliente cliente){
		System.out.println("addCliente()");		
		return clienteRepository.save(cliente);
	}
    
	@Override	
	@CacheEvict(value= "NomeCliente", key= "#cliente.codigo")    
	public Cliente updateCliente(Cliente cliente) {
		System.out.println("updateCliente()");		
		return clienteRepository.save(cliente);
	}

} 