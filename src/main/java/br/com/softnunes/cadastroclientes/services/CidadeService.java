package br.com.softnunes.cadastroclientes.services;

import java.util.List;

import br.com.softnunes.cadastroclientes.application.dto.CidadeDTO;
import br.com.softnunes.cadastroclientes.application.dto.CidadeDTO.CidadeInterfaceDTO;
import br.com.softnunes.cadastroclientes.entities.cidade.Cidade;

public interface CidadeService {
	
	void cadastrarCidade(CidadeDTO cidadeDTO);
	
	Cidade buscarPorNome(String nome);
	
	CidadeDTO buscarPorNomeDTO(String nome);
	
	Cidade buscarPorNomeAndSiglaEstado(String nome, String siglaEstado);
	
	List<CidadeInterfaceDTO> buscaCidadePeloNomeEstado(String nome, Integer limite, Integer offset);
	
	List<CidadeInterfaceDTO> buscaCidadePelaSiglaEstado(String sigla, Integer limite, Integer offset);
}
