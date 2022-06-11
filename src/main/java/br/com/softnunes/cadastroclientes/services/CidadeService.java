package br.com.softnunes.cadastroclientes.services;

import java.util.List;

import br.com.softnunes.cadastroclientes.application.dto.CidadeDTO;
import br.com.softnunes.cadastroclientes.entities.Cidade;

public interface CidadeService {
	
	void cadastrarCidade(CidadeDTO cidadeDTO);
	
	Cidade buscarPorNome(String nome);
	
	CidadeDTO buscarPorNomeDTO(String nome);
	
	Cidade buscarPorNomeAndSiglaEstado(String nome, String siglaEstado);
	
	List<CidadeDTO> buscaCidadePeloNomeEstado(String nome, Integer limite, Integer offset);
	
	List<CidadeDTO> buscaCidadePelaSiglaEstado(String sigla, Integer limite, Integer offset);
}
