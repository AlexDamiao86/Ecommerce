package br.com.ecommerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.model.ItemPedido;
import br.com.ecommerce.model.ItemPedidoPK;
import br.com.ecommerce.model.Pedido;
import br.com.ecommerce.model.Produto;

@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Integer>{
	
//	@Query("SELECT ip FROM item_pedido WHERE ip.codigoItemPedido = :codigoItemPedido")
//	public ItemPedido findByCodigoItemPedido(@Param("codigoItemPedido") String codigoItemPedido);
	
	@Query
	public ItemPedido findByItemPedidoPK(ItemPedidoPK itemPedidoPK);
	
	@Query
	public ItemPedido findByPedido(Pedido pedido);
	
	@Query
	public ItemPedido findByProduto(Produto produto);
}
