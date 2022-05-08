package br.com.ecommerce.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.ecommerce.model.Cliente;
import br.com.ecommerce.service.IClienteService;

@RestController
@RequestMapping("ecommerce")
public class ClienteController {
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping("cliente")
	public ResponseEntity<Void> addEndereco(
			@RequestBody Cliente cliente, 
			UriComponentsBuilder builder) {
		Cliente cli = clienteService.addCliente(cliente);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/cliente/"+cli.getCodigo()).buildAndExpand().toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@GetMapping("clientes/all")
	public ResponseEntity<List<Cliente>> getAllClientes() {
		List<Cliente> listaClientes = clienteService.getAllClientes();
		return new ResponseEntity<List<Cliente>>(listaClientes, HttpStatus.OK);
	}
	
	@PutMapping("cliente")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {
		clienteService.updateCliente(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@DeleteMapping("cliente/{codigo}")
	public ResponseEntity<Void> deleteCliente(@PathVariable("codigo") Integer codigo) {
		try {
			clienteService.deleteCliente(codigo);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}catch(IllegalArgumentException e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("cliente/{codigo}")
	public ResponseEntity<Cliente> getClienteByCodigo(@PathVariable("codigo") Integer codigo) {
		Cliente cliente = new Cliente();
		try {
			cliente = clienteService.getClienteByCodigo(codigo);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Cliente>(cliente, HttpStatus.NOT_FOUND);
		}
	}
}
