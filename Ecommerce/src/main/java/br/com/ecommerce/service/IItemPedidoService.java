package br.com.ecommerce.service;

import java.util.List;

import br.com.ecommerce.model.ItemPedido;

public interface IItemPedidoService {

	List<ItemPedido> getAllItemPedidos();
//	ItemPedido addItemPedido(ItemPedido itemPedido);
	ItemPedido getItemPedidoByCodigoItemPedido(Integer codigoItemPedido);
//	ItemPedido getItemPedidoByCodigoItemPedido(Integer codigoItemPedido);
	List<ItemPedido> findByCodigoProduto(Integer codigoProduto);
	List<ItemPedido> findByCodigoPedido(Integer codigoPedido);
//	ItemPedido updateItemPedido(ItemPedido itemPedido);
//	void deleteItemPedido(ItemPedidoPK itemPedidoPK);
}
