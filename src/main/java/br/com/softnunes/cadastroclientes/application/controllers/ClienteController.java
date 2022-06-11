package br.com.softnunes.cadastroclientes.application.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softnunes.cadastroclientes.application.dto.ClienteDTO;
import br.com.softnunes.cadastroclientes.services.ClienteService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/v1/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping(path = "/novo-cliente", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Cadastra um novo cliente") 
	public ResponseEntity<HttpStatus> novoCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
		clienteService.novoCliente(clienteDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PatchMapping(path = "/editar-cliente")
	@ApiOperation(value = "Editar um cliente")
	public ResponseEntity<HttpStatus> editarCliente(@RequestBody ClienteDTO clienteDTO) {
		clienteService.editarCliente(clienteDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/remover-cliente-por-id/{id}")
	@ApiOperation(value = "Remover cliente por ID")
	public ResponseEntity<HttpStatus> removerClientePorID(@PathVariable("id") Integer id) {
		clienteService.removerCliente(id);
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	@GetMapping(path = "/buscar-cliente-por-id/{id}")
	@ApiOperation(value = "Busca um cliente por ID")
	public ResponseEntity<ClienteDTO> buscarClientePorID(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(clienteService.buscarClientePorID(id));
	}
	
	@GetMapping(path = "/buscar-cliente-por-cpf/{cpf}")
	@ApiOperation(value = "Busca um cliente por cpf")
	public ResponseEntity<ClienteDTO> buscarClientePorCpf(@PathVariable("cpf") String cpf) {
		return ResponseEntity.ok(clienteService.buscarClientePorCpf(cpf));
	}
	
	@GetMapping(path = "/buscar-cliente-por-nome/{nome}")
	@ApiOperation(value = "Busca um cliente pelo nome")
	public ResponseEntity<ClienteDTO> buscarClientePorNome(@PathVariable("nome") String nome) {
		return ResponseEntity.ok(clienteService.buscarClientePorNome(nome));
	}
	
	@ApiOperation(value = "Lista todos clientes de forma paginada") 
	@GetMapping(path = "/lista-clientes/limite/{limite}/offset/{offset}")
	public ResponseEntity<List<ClienteDTO>> listaClientes( @PathVariable("limite") Integer limite, 
					@PathVariable("offset") Integer offset) {
		return ResponseEntity.ok(clienteService.listaClientes(limite, offset));
	}
}
