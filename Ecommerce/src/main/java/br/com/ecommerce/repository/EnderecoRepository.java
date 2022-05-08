package br.com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.ecommerce.model.Endereco;


public interface EnderecoRepository extends CrudRepository<Endereco, Long>{

	List<Endereco> findByLogradouro(String logradouro);
	
	@Query(value="SELECT * FROM Endereco e WHERE e.codigo_cliente_fk = :idCliente", nativeQuery = true)
	List<Endereco> findByCliente(@Param("idCliente") Integer idCliente);
	
	@Query("SELECT e FROM Endereco e WHERE e.idEndereco = :idEndereco")
	Endereco findByIdEndereco(@Param("idEndereco") Long idEndereco);
	
	@Modifying
	@Query("DELETE FROM Endereco e WHERE e.idEndereco = :idEndereco")
	void deleteByIdEndereco(@Param("idEndereco") Long idEndereco);

	@Query("SELECT e FROM Pedido p, Endereco e WHERE (p.enderecoEntrega.idEndereco = :idEndereco) AND (p.enderecoEntrega.idEndereco = e.idEndereco)")
	Endereco findEnderecoFromPedido(@Param("idEndereco") Long idEndereco);
	
}
