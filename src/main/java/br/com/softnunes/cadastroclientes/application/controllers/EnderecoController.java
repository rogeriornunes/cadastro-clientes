package br.com.softnunes.cadastroclientes.application.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softnunes.cadastroclientes.application.dto.EnderecoDTO;
import br.com.softnunes.cadastroclientes.services.impl.EnderecoServiceImpl;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/v1/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoServiceImpl enderecoService;
	
	@PostMapping(path = "/cadastrar-novo-endereco")
	@ApiOperation(value = "Cadastra um novo Endereco")
	public ResponseEntity<HttpStatus> cadastrarNovoEndereco(@Valid @RequestBody EnderecoDTO enderecoDTO) {
		enderecoService.cadastrarEndereco(enderecoDTO);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
