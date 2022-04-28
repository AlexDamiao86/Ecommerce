package br.com.ecommerce.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.model.ItemPedido;
import br.com.ecommerce.model.ItemPedidoPK;
import br.com.ecommerce.service.IItemPedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ecommerce")
@Api(value = "Controle de Itens-Pedidos")
@CrossOrigin(origins = "*")
public class ItemPedidoController {
	
	@Autowired
	private IItemPedidoService itemPedidoService;
	
	@GetMapping("itemPedidos")
	@ApiOperation(value = "Retorna todos os ItemPedidos cadastrados")
	public ResponseEntity<List<ItemPedido>> getAllItemPedidos(){
		try {
		List<ItemPedido> listaItemPedidos = itemPedidoService.getAllItemPedidos();
		return new ResponseEntity<List<ItemPedido>>(listaItemPedidos, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<ItemPedido>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("itemPedido/{codigoItemPedido}")
	@ApiOperation(value = "Retorna um ItemPedido único")
	public ResponseEntity<ItemPedido> getItemPedidoByItemPedidoPK(@PathVariable("codigoItemPedido") ItemPedidoPK itemPedidoPK) {
		try {
			ItemPedido itemPedido = itemPedidoService.getItemPedidoByItemPedidoPK(itemPedidoPK);
			return new ResponseEntity<ItemPedido>(itemPedido, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<ItemPedido>(HttpStatus.NOT_FOUND);
		}
	}
}
