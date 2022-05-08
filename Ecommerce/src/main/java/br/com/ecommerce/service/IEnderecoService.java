package br.com.ecommerce.service;

import java.util.Collection;
import java.util.List;

import br.com.ecommerce.model.Endereco;

public interface IEnderecoService {
	 Endereco addEndereco(Endereco endereco);
	 List<Endereco> getAllEnderecos();
	 void addAll(Collection<Endereco> enderecos);
	 List<Endereco> findByLogradouro(String logradouro);
	 List<Endereco> findByCliente(Integer idCliente);
	 Endereco updateEndereco(Endereco end);
	 boolean existePedidoEndereco(Long idEndereco);
	 void deleteEndereco(Long idEndereco);
}
