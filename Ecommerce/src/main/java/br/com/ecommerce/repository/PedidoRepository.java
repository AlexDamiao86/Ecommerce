package br.com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.ecommerce.model.Cliente;
import br.com.ecommerce.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
	@Query
	public Pedido findByCodigo(Integer codigo);
	
	@Query
	public List<Pedido> findByCliente(Cliente cliente);
}
