package br.com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.ecommerce.model.Endereco;


public interface EnderecoRepository extends CrudRepository<Endereco, Integer>{

	List<Endereco> findByLogradouro(String logradouro);

}
