package br.com.softnunes.cadastroclientes.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softnunes.cadastroclientes.application.dto.EstadoDTO;
import br.com.softnunes.cadastroclientes.services.EstadoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/v1/estados")
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@PostMapping(path = "/cadastrar-novo-estado")
	@ApiOperation(value = "Cadastra um novo Estado")
	public ResponseEntity<HttpStatus> cadastrarNovoEstado(@RequestBody EstadoDTO estadoDTO) {
		estadoService.cadastrarEstado(estadoDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
