package br.com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.model.ItemPedido;
import br.com.ecommerce.service.IItemPedidoService;

@RestController
@RequestMapping
public class ItemPedidoController {
	
	@Autowired
	private IItemPedidoService itemPedidoService;
	
	@GetMapping("/itemPedidos")
	public ResponseEntity<List<ItemPedido>> getAllItemPedidos(){
		List<ItemPedido> listaItemPedidos = itemPedidoService.getAllItemPedidos();
		return new ResponseEntity<List<ItemPedido>>(listaItemPedidos, HttpStatus.OK);
	}
}
