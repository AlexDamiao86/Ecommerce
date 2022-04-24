package br.com.ecommerce.repository;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.model.ItemPedido;

@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Integer>{
	
//	@Query("SELECT ip FROM item_pedido WHERE ip.codigoItemPedido = :codigoItemPedido")
//	public ItemPedido findByCodigoItemPedido(@Param("codigoItemPedido") Integer codigoItemPedido);
	
//	@Query ("SELECT ip FROM item_pedido WHERE ip.itemPedidoPK = :itemPedidoPk")
//	public ItemPedido findByItemPedidoPK(ItemPedidoPK itemPedidoPK);
	
//	@Query
//	public ItemPedido findByPedido(Pedido pedido);
//	
//	@Query
//	public ItemPedido findByProduto(Produto produto);
}
