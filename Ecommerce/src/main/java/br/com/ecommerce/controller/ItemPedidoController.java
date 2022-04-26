package br.com.ecommerce.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ecommerce.model.ItemPedido;
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
	
	// List All
	@GetMapping("itempedidos")
	@ApiOperation(value = "Retorna todos os ItemPedidos cadastrados")
	public ResponseEntity<List<ItemPedido>> getAllItemPedidos(){
		try {
			List<ItemPedido> listaItemPedidos = itemPedidoService.getAllItemPedidos();
			return new ResponseEntity<List<ItemPedido>>(listaItemPedidos, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<ItemPedido>>(HttpStatus.NOT_FOUND);
		}
	}
	
	// List Todos item-pedidos por codigo de produto
	@GetMapping("itempedidosporproduto/{codigoProduto}")
	@ApiOperation(value = "Retorna todos os ItemPedidos de um produto")
	public ResponseEntity<List<ItemPedido>> findByCodigoProduto(@PathVariable("codigoProduto") Integer codigoProduto){
		try {
			List<ItemPedido> listaItemPedidos = itemPedidoService.findByCodigoProduto(codigoProduto);
			return new ResponseEntity<List<ItemPedido>>(listaItemPedidos, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<ItemPedido>>(HttpStatus.NOT_FOUND);
		}
	}
	
	// List Todos item-pedidos por codigo de pedido
	@GetMapping("itempedidosporpedido/{codigoPedido}")
	@ApiOperation(value = "Retorna todos os ItemPedidos de um pedido")
	public ResponseEntity<List<ItemPedido>> findByCodigoPedido(@PathVariable("codigoPedido") Integer codigoPedido){
		try {
			List<ItemPedido> listaItemPedidos = itemPedidoService.findByCodigoPedido(codigoPedido);
			return new ResponseEntity<List<ItemPedido>>(listaItemPedidos, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<ItemPedido>>(HttpStatus.NOT_FOUND);
		}
	}

	
	// Select 1
	@GetMapping("itempedido/{codigoItemPedido}")
	@ApiOperation(value = "Retorna um ItemPedido único pelo codigo")
	public ResponseEntity<ItemPedido> getItemPedidoByCodigoItemPedido(@PathVariable("codigoItemPedido") Integer codigoItemPedido) {
		try {
			ItemPedido itemPedido = itemPedidoService.getItemPedidoByCodigoItemPedido(codigoItemPedido);
			return new ResponseEntity<ItemPedido>(itemPedido, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<ItemPedido>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Adiciona
	@PostMapping("itempedido")
	public ResponseEntity<Void> addItemPedido(@RequestBody ItemPedido itemPedido, UriComponentsBuilder builder) {
		try {
			ItemPedido novoItemPedido = itemPedidoService.addItemPedido(itemPedido);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/itempedido/" + novoItemPedido.getItemPedidoPK().getcodigoItemPedido()).buildAndExpand().toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} catch (DataIntegrityViolationException | HttpMessageNotReadableException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// Update
	@PutMapping("itempedido")
	public ResponseEntity<ItemPedido> updateEndereco(@RequestBody ItemPedido novoItemPedido) {
		try {
			itemPedidoService.updateItemPedido(novoItemPedido);
			return new ResponseEntity<ItemPedido>(novoItemPedido, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<ItemPedido>(HttpStatus.NOT_FOUND);
		} catch (DataIntegrityViolationException | HttpMessageNotReadableException e) {
			return new ResponseEntity<ItemPedido>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// Delete
	@DeleteMapping("itemPedido/{codigoItemPedido}")
	@ApiOperation(value = "Deleta um vinculo itemPedido através da ID")
	public ResponseEntity<Void> deleteById(@PathVariable("codigoItemPedido") Integer codigoItemPedido) {
		try {
			itemPedidoService.deleteByCodigo(codigoItemPedido);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
