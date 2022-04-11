package br.com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import br.com.ecommerce.model.Cliente;
import br.com.ecommerce.model.EstadoPedido;
import br.com.ecommerce.model.Pedido;
import br.com.ecommerce.repository.PedidoRepository;

@Component
public class PedidoService implements IPedidoService{
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	@Cacheable(value = "allPedidosCache", unless = "#result.size() == 0")
	public List<Pedido> getAllPedidos() {
		System.out.println("getAllPedidos()");
		List<Pedido> listaPedido = new ArrayList<>();
		pedidoRepository.findAll().forEach(pedido -> listaPedido.add(pedido));
		return listaPedido;
	}

	@Override
	@Cacheable(value = "pedidoCache", key = "#codigo")
	public Pedido getPedidoByCodigo(Integer codigo) {
		System.out.println("getPedidoByCodigo()");
		return pedidoRepository.findById(codigo).get();
	}

	public List<Pedido> getPedidoByCliente(Cliente cliente) {
		System.out.println("getPedidoByNome()");
		return pedidoRepository.findByCliente(cliente);
	}

	@Override
	@Caching(put = { @CachePut(value = "pedidoCache", key = "#pedido.codigo") }, evict = {
			@CacheEvict(value = "allPedidosCache", allEntries = true) })
	public Pedido addPedido(Pedido pedido) {
		System.out.println("addPedido()");
		return pedidoRepository.save(pedido);
	}

	@Override
	@Caching(put = { @CachePut(value = "pedidoCache", key = "#pedido.codigo") }, evict = {
			@CacheEvict(value = "allPedidosCache", allEntries = true) })	
	public Pedido updatePedido(Pedido pedido) {
		System.out.println("updatePedido()");
		return pedidoRepository.save(pedido);
	}

	@Override
	@Caching(put = { @CachePut(value = "pedidoCache", key = "#pedido.codigo") }, evict = {
			@CacheEvict(value = "allPedidosCache", allEntries = true) })	
	public Pedido deletePedido(Integer codigo) {
		System.out.println("deletePedido()");
		Pedido pedido = pedidoRepository.findByCodigoPedido(codigo);
		pedido.setEstado(EstadoPedido.CANCELADO);
		return pedidoRepository.save(pedido);
	}

}
