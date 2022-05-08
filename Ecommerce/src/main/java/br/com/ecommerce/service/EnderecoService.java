package br.com.ecommerce.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import br.com.ecommerce.model.Endereco;
import br.com.ecommerce.repository.EnderecoRepository;

@Component
public class EnderecoService implements IEnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Transactional
	public Endereco addEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	@Transactional(readOnly = true)
	public List<Endereco> getAllEnderecos() {
		return (List<Endereco>)enderecoRepository.findAll();
	}
	
	@Transactional
	public void addAll(Collection<Endereco> enderecos) {
		for (Endereco end: enderecos) {
			enderecoRepository.save(end);
		}
	}
	
	@Transactional(readOnly = true)
	public List<Endereco> findByLogradouro(String logradouro) {
		return enderecoRepository.findByLogradouro(logradouro);
	}

	@Transactional(readOnly = true)
	public List<Endereco> findByCliente(Integer idCliente) {
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		listaEndereco = enderecoRepository.findByCliente(idCliente);
		if(listaEndereco.size() != 0) {
			return  listaEndereco;
		}
		else {
			throw new NoSuchElementException("Não Encontrado endereco para o cliente");
		}
	}
	
	@Transactional
	public Endereco updateEndereco(Endereco end) {
		return enderecoRepository.save(end);
	}
	
	
	
    @Transactional
	public void deleteEndereco(Long idEndereco) {
    	if (existePedidoEndereco(idEndereco)) {
    		throw new  DataIntegrityViolationException("Não é possível deletar: endereco ainda vinculado a um pedido");
    	}
		enderecoRepository.deleteByIdEndereco(idEndereco);
	}

    @Transactional(readOnly = true)
	public boolean existePedidoEndereco(Long idEndereco) {
    	Endereco e = enderecoRepository.findEnderecoFromPedido(idEndereco);
		if (e != null) {
			return true;
		}
		return false;
	}

}
