package br.com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import br.com.ecommerce.model.ItemPedido;
import br.com.ecommerce.model.Pedido;
import br.com.ecommerce.model.Produto;
import br.com.ecommerce.repository.ItemPedidoRepository;

@Component
public class ItemPedidoService implements IItemPedidoService {
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	@Cacheable(value = "allItemPedidosCache", unless = "#result.size() == 0")
	public List<ItemPedido> getAllItemPedidos() {
		List<ItemPedido> listaItemPedidos = new ArrayList<>();
		itemPedidoRepository.findAll().forEach(itemPedido -> listaItemPedidos.add(itemPedido));
		return listaItemPedidos;
	}

	@Override
	public ItemPedido addItemPedido(ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}
	
	@Override
	public ItemPedido getItemPedidoByCodigoItemPedido(Integer codigoItemPedido) {
		return itemPedidoRepository.findByCodigoItemPedido(codigoItemPedido);
	}

	@Override
	public ItemPedido getItemPedidoByPedido(Pedido pedido) {
		return itemPedidoRepository.findByPedido(pedido);
	}

	@Override
	public ItemPedido getItemPedidoByProduto(Produto produto) {
		return itemPedidoRepository.findByProduto(produto);
	}

	@Override
	public ItemPedido updateItemPedido(ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}

	@Override
	public void deleteItemPedido(Integer codigoItemPedido) {
		itemPedidoRepository.delete(itemPedidoRepository.findByCodigoItemPedido(codigoItemPedido));
	}

}
