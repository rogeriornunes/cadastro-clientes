package br.com.softnunes.cadastroclientes.services.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softnunes.cadastroclientes.application.dto.EnderecoDTO;
import br.com.softnunes.cadastroclientes.entities.Endereco;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.EnderecoRepository;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.mappers.EnderecoMapper;
import br.com.softnunes.cadastroclientes.services.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EnderecoMapper enderecoMapper;
	
	@Override
	public void cadastrarEndereco(EnderecoDTO enderecoDTO) {
		Endereco endereco = enderecoMapper.fromDTO(enderecoDTO);	
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
	
	@Override
	public void removerEndereco(Integer id) {
		if (enderecoRepository.existsById(id)) {
			enderecoRepository.deleteById(id);
		}
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
