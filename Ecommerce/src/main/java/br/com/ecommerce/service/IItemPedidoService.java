package br.com.ecommerce.service;

import java.util.List;

import br.com.ecommerce.model.ItemPedido;
import br.com.ecommerce.model.Pedido;
import br.com.ecommerce.model.Produto;

public interface IItemPedidoService {

	List<ItemPedido> getAllItemPedidos();
	ItemPedido addItemPedido(ItemPedido itemPedido);
	ItemPedido getItemPedidoByCodigoItemPedido(Integer codigoItemPedido);
	ItemPedido getItemPedidoByPedido(Pedido pedido);
	ItemPedido getItemPedidoByProduto(Produto produto);
	ItemPedido updateItemPedido(ItemPedido itemPedido);
	void deleteItemPedido(Integer codigoItemPedido);
}
