package br.com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.ecommerce.model.Pedido;
import br.com.ecommerce.service.IPedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ecommerce")
@Api(value = "Controle de Pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {
	
	@Autowired
	private IPedidoService pedidoService;
	
	@GetMapping("pedidos")
	@ApiOperation(value = "Retorna todos os Pedidos cadastrados")
	public ResponseEntity<List<Pedido>> getAllPedidos() {
		List<Pedido> listaPedidos = pedidoService.getAllPedidos();
		return new ResponseEntity<List<Pedido>>(listaPedidos, HttpStatus.OK);
	}
	
	@GetMapping("pedido/{codigo}")
	@ApiOperation(value = "Retorna um Pedido único")
	public ResponseEntity<Pedido> getPedidoByCodigo(@PathVariable("codigo") Integer codigo) {
		Pedido pedido = pedidoService.getPedidoByCodigo(codigo);
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
	}
	
	@PostMapping("pedido")
	@ApiOperation(value = "Adiciona um Pedido")
	public ResponseEntity<Void> addPedido(
			@RequestBody Pedido pedido, 
			UriComponentsBuilder builder) {
		Pedido pedidoSalvo = pedidoService.addPedido(pedido);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/pedido/{codigo}").buildAndExpand(pedidoSalvo.getCodigo()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("pedido")
	@ApiOperation(value = "Altera um Pedido")
	public ResponseEntity<Pedido> updatePedido(
			@RequestBody Pedido pedido) {
		pedidoService.updatePedido(pedido);
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
	}
	
	@PutMapping("pedidodelete/{codigo}")
	@ApiOperation(value = "Deleta um Pedido")
	public ResponseEntity<Void> deletePedido(@PathVariable("codigo") Integer codigo) {
		pedidoService.deletePedido(codigo);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
