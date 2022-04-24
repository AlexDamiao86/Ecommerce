package br.com.ecommerce.service;

import java.util.List;

import br.com.ecommerce.model.ItemPedido;

public interface IItemPedidoService {

	List<ItemPedido> getAllItemPedidos();
//	ItemPedido addItemPedido(ItemPedido itemPedido);
	ItemPedido getItemPedidoByCodigoItemPedido(Integer codigoItemPedido);
//	ItemPedido getItemPedidoByItemPedidoPK(ItemPedidoPK itemPedidoPK);
//	ItemPedido getItemPedidoByPedido(Pedido pedido);
//	ItemPedido getItemPedidoByProduto(Produto produto);
//	ItemPedido updateItemPedido(ItemPedido itemPedido);
//	void deleteItemPedido(ItemPedidoPK itemPedidoPK);
}
