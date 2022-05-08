package br.com.ecommerce.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;
import br.com.ecommerce.model.Cliente;
import br.com.ecommerce.repository.ClienteRepository;


@Component
public class ClienteService implements IClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override		
	public Cliente getClienteByCpf(String cpf) {
		System.out.println("getClienteByCpf()");		
		return clienteRepository.findByCpf(cpf);
	}
	
	@Override		
	public Cliente getClienteByCodigo(Integer codigo) {
		System.out.println("getClienteByCodigo()");	
		Cliente c = clienteRepository.findByCodigoCliente(codigo);
		if (c != null) {
			return c;
		}else {
			throw new NoSuchElementException("Não foi encontrado cliente com esse código");
		}
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
	@Caching( evict = {  
						@CacheEvict(value = "allPedidosCache", allEntries = true),
						@CacheEvict(value = "pedidoCache", allEntries = true)
			           })	
	public Cliente updateCliente(Cliente cliente) {
		System.out.println("updateCliente()");		
		return clienteRepository.save(cliente);
	}
	
	@Override
	public List<Cliente> getAllClientes() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	@CacheEvict(value= "NomeCliente", key= "#cliente.codigo")
	public void deleteCliente(Integer codigo) {
		System.out.println("deleteProduto()");
		clienteRepository.delete(clienteRepository.findById(codigo).get());
	}
	
} 