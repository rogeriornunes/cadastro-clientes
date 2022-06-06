package br.com.softnunes.cadastroclientes.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softnunes.cadastroclientes.application.dto.CidadeDTO;
import br.com.softnunes.cadastroclientes.application.dto.CidadeDTO.CidadeInterfaceDTO;
import br.com.softnunes.cadastroclientes.services.impl.CidadeServiceImpl;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/v1/cidades")
public class CidadeController {
	
	@Autowired
	private CidadeServiceImpl cidadeService;
	
	@ApiOperation(value = "Cadastra uma nova cidade") 
	@PostMapping(path = "/cadastrar-nova-cidade")
	public ResponseEntity<HttpStatus> cadastrarCidade(@RequestBody CidadeDTO cidadeDTO) {
		cidadeService.cadastrarCidade(cidadeDTO);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Busca uma cidade pelo nome") 
	@GetMapping(path = "/buscar-cidade-pelo-nome/{nome}")
	public ResponseEntity<CidadeDTO> buscarCidadePeloNome(@PathVariable("nome") String nome) {
		return ResponseEntity.ok(cidadeService.buscarPorNomeDTO(nome));
	}
	
	@ApiOperation(value = "Busca uma cidade pelo nome do Estado") 
	@GetMapping(path = "/buscar-cidade-pelo-estado/nome/{nome}/limite/{limite}/offset/{offset}")
	public ResponseEntity<List<CidadeInterfaceDTO>> buscarCidadePeloNomeEstado(@PathVariable("nome") String nome, 
			@PathVariable("limite") Integer limite, @PathVariable("offset") Integer offset) {
		
		return ResponseEntity.ok(cidadeService.buscaCidadePeloNomeEstado(nome, limite, offset));
	}
	
	@ApiOperation(value = "Busca uma cidade pela sigla do Estado") 
	@GetMapping(path = "/buscar-cidade-pelo-estado/sigla/{sigla}/limite/{limite}/offset/{offset}")
	public ResponseEntity<List<CidadeInterfaceDTO>> buscarCidadePelaSiglaEstado(@PathVariable("sigla") String sigla, 
			@PathVariable("limite") Integer limite, @PathVariable("offset") Integer offset) {
		
		return ResponseEntity.ok(cidadeService.buscaCidadePelaSiglaEstado(sigla, limite, offset));
	}
}
