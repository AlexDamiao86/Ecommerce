package br.com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.model.ItemPedido;
import br.com.ecommerce.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService implements IItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

//	@Override
//	@Cacheable(value = "allItemPedidosCache", unless = "#result.size() == 0")
	public List<ItemPedido> getAllItemPedidos() {
		System.out.println("Listando todos os produtos");
		List<ItemPedido> listaItemPedidos = new ArrayList<>();
		itemPedidoRepository.findAll().forEach(itemPedido -> listaItemPedidos.add(itemPedido));
		return listaItemPedidos;
	}
//	@Override
//	public ItemPedido getItemPedidoByItemPedidoPK(ItemPedidoPK itemPedidoPK) {
//		return itemPedidoRepository.findByItemPedidoPK(itemPedidoPK);
//	}

	@Override
	public ItemPedido getItemPedidoByCodigoItemPedido(Integer codigoItemPedido) {
		return itemPedidoRepository.findById(codigoItemPedido).get();
	}
	
//	
//	@Override
//	public ItemPedido addItemPedido(ItemPedido itemPedido) {
//		return itemPedidoRepository.save(itemPedido);
//	}
//	
//	  @Override public ItemPedido getItemPedidoByPedido(Pedido pedido) { return
//	  itemPedidoRepository.findByPedido(pedido); }
//	  
//	  @Override public ItemPedido getItemPedidoByProduto(Produto produto) { return
//	  itemPedidoRepository.findByProduto(produto); }
	 

//	@Override
//	public ItemPedido updateItemPedido(ItemPedido itemPedido) {
//		return itemPedidoRepository.save(itemPedido);
//	}
//
//	@Override
//	public void deleteItemPedido(ItemPedidoPK itemPedidoPK) {
//		itemPedidoRepository.delete(itemPedidoRepository.findByItemPedidoPK(itemPedidoPK));
//	}

}
