package br.com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.model.ItemPedido;

@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Integer>{
	
	public ItemPedido findByCodigoItemPedido(@Param("codigoItemPedido") Integer codigoItemPedido);
//	@Query(value = "SELECT * FROM item_pedido ip WHERE ip.codigoItemPedido = :codigoItemPedido",
//			nativeQuery = true)
//	public ItemPedido findByCodigoItemPedido(@Param("codigoItemPedido") Integer codigoItemPedido);
	
	@Query(value = "SELECT * FROM item_pedido ip WHERE ip.codigoProduto = :codigoProduto",
			nativeQuery = true)
	public List<ItemPedido> findByCodigoProduto(@Param("codigoProduto") Integer codigoProduto);
	
	@Query(value = "SELECT * FROM item_pedido ip WHERE ip.codigoPedido = :codigoPedido",
			nativeQuery = true)
	public List<ItemPedido> findByCodigoPedido(@Param("codigoPedido") Integer codigoPedido);
	
//	@Query ("SELECT ip FROM item_pedido WHERE ip.itemPedidoPK = :itemPedidoPk")
//	public ItemPedido findByItemPedidoPK(ItemPedidoPK itemPedidoPK);
	
//	@Query
//	public ItemPedido findByPedido(Pedido pedido);
//
}
