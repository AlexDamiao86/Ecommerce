package br.com.ecommerce.service;

import java.util.List;

import br.com.ecommerce.model.ItemPedido;
import br.com.ecommerce.model.ItemPedidoPK;
import br.com.ecommerce.model.Pedido;
import br.com.ecommerce.model.Produto;

public interface IItemPedidoService {

	List<ItemPedido> getAllItemPedidos();
	ItemPedido addItemPedido(ItemPedido itemPedido);
	ItemPedido getItemPedidoByItemPedidoPK(ItemPedidoPK itemPedidoPK);
	ItemPedido getItemPedidoByPedido(Pedido pedido);
	ItemPedido getItemPedidoByProduto(Produto produto);
	ItemPedido updateItemPedido(ItemPedido itemPedido);
	void deleteItemPedido(ItemPedidoPK itemPedidoPK);
}
