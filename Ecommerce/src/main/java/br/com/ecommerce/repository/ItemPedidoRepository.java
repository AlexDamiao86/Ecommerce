package br.com.ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.model.ItemPedido;

@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Integer>{
	
	public ItemPedido findByItemPedidoPK_codigoItemPedidoPK(@Param("codigoItemPedido") Integer codigoItemPedido);
//	public ItemPedido findByCodigoItemPedido(@Param("codigoItemPedido") Integer codigoItemPedido);
//	@Query(value = "SELECT * FROM item_pedido ip WHERE ip.codigoItemPedido = :codigoItemPedido",
//			nativeQuery = true)
//	public ItemPedido findByCodigoItemPedido(@Param("codigoItemPedido") Integer codigoItemPedido);

	public List<ItemPedido> findByItemPedidoPK_codigoProdutoPK(@Param("codigoProduto") Integer codigoProduto);

	public List<ItemPedido> findByItemPedidoPK_codigoPedidoPK(@Param("codigoPedido") Integer codigoPedido);
	
}
