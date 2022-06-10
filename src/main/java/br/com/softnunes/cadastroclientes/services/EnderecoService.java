package br.com.softnunes.cadastroclientes.services;

import br.com.softnunes.cadastroclientes.application.dto.EnderecoDTO;
import br.com.softnunes.cadastroclientes.entities.Endereco;

public interface EnderecoService {
	
	void cadastrarEndereco(EnderecoDTO enderecoDTO);	
	
	Endereco buscarPorCepNumero(String cep, Integer numero);
}
