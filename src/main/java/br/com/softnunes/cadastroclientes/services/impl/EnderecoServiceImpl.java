package br.com.softnunes.cadastroclientes.services.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softnunes.cadastroclientes.application.convert.EnderecoConverter;
import br.com.softnunes.cadastroclientes.application.dto.EnderecoDTO;
import br.com.softnunes.cadastroclientes.entities.Endereco;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.EnderecoRepository;
import br.com.softnunes.cadastroclientes.services.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public void cadastrarEndereco(EnderecoDTO enderecoDTO) {
		Endereco endereco = EnderecoConverter.convertToEndereco(enderecoDTO);	
		this.enderecoRepository.saveAndFlush(endereco);
	}
	
	@Override
	public Endereco buscarPorCepNumero(String cep, Integer numero) {
		Optional<Endereco> endereco = enderecoRepository.findByEnderecoPorCepNumero(cep, numero);
		if (!endereco.isPresent()) {		
			throw new NoSuchElementException(getMensagemException(cep, numero));		
		}
		return endereco.get();	
	}
	
	private String getMensagemException(String cep, Integer numero) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("O endereço no CEP: ");
		stringBuilder.append(cep);
		stringBuilder.append(" com número: ");
		stringBuilder.append(numero);
		stringBuilder.append(" não existe.");

		return stringBuilder.toString();
	}

}
