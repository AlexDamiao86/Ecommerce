package br.com.ecommerce.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.ecommerce.model.Endereco;


public interface EnderecoRepository extends CrudRepository<Endereco, Long>{

	List<Endereco> findByLogradouro(String logradouro);
	
	@Query("SELECT e FROM Endereco e WHERE e.enderecoPK.cliente.codigo = :idCliente")
	List<Endereco> findByCliente(@Param("idCliente") Integer idCliente);
	@Query("SELECT e FROM Endereco e WHERE e.enderecoPK.idEndereco = :idEndereco")
	Endereco findByIdEndereco(@Param("idEndereco") Long idEndereco);
}
