package br.com.ecommerce.controller;

import java.util.List;
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
import br.com.ecommerce.model.Endereco;
import br.com.ecommerce.service.IEnderecoService;

@RestController
@RequestMapping("ecommerce")
public class EnderecoController {

	@Autowired
	private IEnderecoService enderecoService;

//	@GetMapping("enderecos/all")
//	public ResponseEntity<List<EnderecoDTO>> getAllEnderecos() {
//		List<Endereco> listaEnderecos = enderecoService.getAllEnderecos();
//		List<EnderecoDTO> ends = new ArrayList<EnderecoDTO>();
//		for (Endereco e: listaEnderecos) {
//			Cliente cliente = e.getCliente();
//			if(cliente != null) {
//				ClienteDTO cli = new ClienteDTO();
//				cli.setNome(cliente.getNome());
//				cli.setCodigo(cliente.getCodigo());
//				cli.setCpf(cliente.getCpf());
//				cli.setDataNascimento(cliente.getDataNascimento());
//				cli.setEmail(cliente.getEmail());
//				EnderecoDTO end = e.toDTO();
//				end.setCliente(cli);
//				ends.add(end);
//			}
//		}
//		return new ResponseEntity<List<EnderecoDTO>>(ends, HttpStatus.OK);
//	}
	
	@GetMapping("enderecos/all")
	public ResponseEntity<List<Endereco>> getAllEnderecos() {
		List<Endereco> listaEnderecos = enderecoService.getAllEnderecos();
		return new ResponseEntity<List<Endereco>>(listaEnderecos, HttpStatus.OK);
	}

	
	@GetMapping("enderecos/{codigoCliente}")
	public ResponseEntity<List<Endereco>> getEnderecoByCodigo(@PathVariable("codigoCliente") Integer codigo) {
		List<Endereco> enderecos = enderecoService.findByCliente(codigo);
		return new ResponseEntity<List<Endereco>>(enderecos, HttpStatus.OK);
	}


	@PostMapping("endereco")
	public ResponseEntity<Void> addEndereco(@RequestBody Endereco endereco, UriComponentsBuilder builder) {
		Endereco end = enderecoService.addEndereco(endereco);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/endereco/" + end.getIdEndereco()).buildAndExpand().toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("endereco")
	public ResponseEntity<Endereco> updateEndereco(@RequestBody Endereco newEnd) {
		enderecoService.updateEndereco(newEnd);
		return new ResponseEntity<Endereco>(newEnd, HttpStatus.OK);
	}

	@DeleteMapping("endereco/{idEndereco}")
	public ResponseEntity<Void> deleteEndereco(@PathVariable("idEndereco") Long idEndereco) {
		enderecoService.deleteEndereco(idEndereco);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
