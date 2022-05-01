package br.com.ecommerce.service;

import java.util.List;


import br.com.ecommerce.model.Pedido;

public interface IPedidoService {
	
	List<Pedido> getAllPedidos();
	Pedido getPedidoByCodigo(Integer codigo);
//	List<Pedido> getPedidoByCliente(Cliente cliente);
	Pedido addPedido(Pedido pedido);
	Pedido updatePedido(Pedido pedido);
	public void deletePedido(Integer codigo);
	

}
