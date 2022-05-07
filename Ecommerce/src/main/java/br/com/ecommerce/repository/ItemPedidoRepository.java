package br.com.ecommerce.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.model.ItemPedido;

@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Integer>{

	public ItemPedido findByCodigoItemPedidoPK (@Param("codigoItemPedidoPK") Integer codigoItemPedidoPK);
//	public List<ItemPedido> findByPedido_codigo(@Param("codigoPedidoPK") Integer codigoPedidoPK);
//	public List<ItemPedido> findByProduto_codigo(@Param("codigoProdutoPK") Integer codigoProdutoPK);
	@Modifying
	@Query("DELETE FROM ItemPedido i WHERE i.codigoItemPedidoPK = :codigoItemPedidoPK")
	public void deleteByCodigoItemPedidoPK(@Param("codigoItemPedidoPK") Integer codigoItemPedidoPK);
}
