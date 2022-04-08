package br.com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.model.Endereco;


public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	List<Endereco> findByLogradouro(String logradouro);

}
