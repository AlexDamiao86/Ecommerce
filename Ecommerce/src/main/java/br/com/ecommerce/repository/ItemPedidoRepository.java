package br.com.ecommerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.ecommerce.model.ItemPedido;
import br.com.ecommerce.model.Produto;
import br.com.ecommerce.model.Pedido;

public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Integer>{
	@Query
	public ItemPedido findByCodigoItemPedido(Integer codigoItemPedido);
	
	@Query
	public ItemPedido findByPedido(Pedido pedido);
	
	@Query
	public ItemPedido findByProduto(Produto produto);
}
