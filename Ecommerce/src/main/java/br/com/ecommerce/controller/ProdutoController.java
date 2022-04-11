package br.com.ecommerce.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import br.com.ecommerce.model.Produto;
import br.com.ecommerce.service.IProdutoService;

@RestController
@RequestMapping("ecommerce")
public class ProdutoController {
	
	@Autowired
	private IProdutoService produtoService;
	
	@GetMapping("produtos")
	public ResponseEntity<List<Produto>> getAllProdutos() {
		List<Produto> listaProdutos = produtoService.getAllProdutos();
		return new ResponseEntity<List<Produto>>(listaProdutos, HttpStatus.OK);
	}
	
	@GetMapping("produto/{codigo}")
	public ResponseEntity<Produto> getProdutoByCodigo(@PathVariable("codigo") Integer codigo) {
		Produto produto = produtoService.getProdutoByCodigo(codigo);
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}
	
	@GetMapping("produto")
	public ResponseEntity<List<Produto>> getProdutoByNome(@RequestParam("nome") String nome) {
		List<Produto> listaProdutos = produtoService.getProdutoByNome(nome);
		return new ResponseEntity<List<Produto>>(listaProdutos, HttpStatus.OK);
	}
	
	@PostMapping("produto")
	public ResponseEntity<Void> addProduto(
			@RequestBody Produto produto, 
			UriComponentsBuilder builder) {
		Produto produtoSalvo = produtoService.addProduto(produto);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/produto/{codigo}").buildAndExpand(produtoSalvo.codigo).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("produto")
	public ResponseEntity<Produto> updateProduto(
			@RequestBody Produto produto) {
		produtoService.updateProduto(produto);
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}
	
	@DeleteMapping("produto/{codigo}")
	public ResponseEntity<Void> deleteProduto(@PathVariable("codigo") Integer codigo) {
		produtoService.deleteProduto(codigo);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}