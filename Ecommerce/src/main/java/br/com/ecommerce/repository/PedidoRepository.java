package br.com.ecommerce.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import br.com.ecommerce.model.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
	@Query
	public Pedido findByCodigo(Integer codigo);
	
}
