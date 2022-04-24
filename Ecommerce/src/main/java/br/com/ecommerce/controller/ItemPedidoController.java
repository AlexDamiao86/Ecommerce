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
	@GetMapping("itemPedido/{codigoItemPedido}")
	@ApiOperation(value = "Retorna um ItemPedido único pelo codigo")
	public ResponseEntity<ItemPedido> getItemPedidoByCodigoItemPedido(@PathVariable("codigoItemPedido") Integer codigoItemPedido) {
		try {
			ItemPedido itemPedido = itemPedidoService.getItemPedidoByCodigoItemPedido(codigoItemPedido);
			return new ResponseEntity<ItemPedido>(itemPedido, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<ItemPedido>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Select 1
//	public ResponseEntity<ItemPedido> getItemPedidoByItemPedidoPK(ItemPedidoPK itemPedidoPK) {
//		try {
//			ItemPedido itemPedido = itemPedidoService.getItemPedidoByItemPedidoPK(itemPedidoPK);
//			return new ResponseEntity<ItemPedido>(itemPedido, HttpStatus.OK);
//		} catch (NoSuchElementException e) {
//			return new ResponseEntity<ItemPedido>(HttpStatus.NOT_FOUND);
//		}
//	}
	
	
	// Insert
//	@PostMapping("itemPedido")
//	public ResponseEntity<Void> addItemPedido(@RequestBody ItemPedido itemPedido,UriComponentsBuilder builder) {
//		try {
//			ItemPedido itemPedidoSalvo = itemPedidoService.addItemPedido(itemPedido);
//			HttpHeaders headers = new HttpHeaders();
//			headers.setLocation(builder.path("/itemPedido/{codigo}").buildAndExpand(itemPedidoSalvo.getItemPedidoPK().getCodigoPedido()).toUri());
//			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);			
//		} catch (DataIntegrityViolationException | HttpMessageNotReadableException e) {
//			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		}
//	}
	
	
}
