package br.com.ecommerce.service;

import java.util.Collection;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.ecommerce.model.Endereco;
import br.com.ecommerce.repository.EnderecoRepository;

public class EnderecoService {
	private EnderecoRepository enderecoRepository;
	@Transactional
	public void add(Endereco enderecos) {
		enderecoRepository.save(enderecos);
	}
	
	@Transactional(readOnly = true)
	public List<Endereco> findAll() {
		return (List<Endereco>) enderecoRepository.findAll();
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
}
