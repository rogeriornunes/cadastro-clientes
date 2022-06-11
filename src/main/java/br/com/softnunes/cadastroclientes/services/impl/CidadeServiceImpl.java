package br.com.softnunes.cadastroclientes.services.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softnunes.cadastroclientes.application.convert.CidadeConverter;
import br.com.softnunes.cadastroclientes.application.dto.CidadeDTO;
import br.com.softnunes.cadastroclientes.entities.Cidade;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.CidadeRepository;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.mappers.CidadeMapper;
import br.com.softnunes.cadastroclientes.services.CidadeService;
import br.com.softnunes.cadastroclientes.services.ClienteService;
import br.com.softnunes.cadastroclientes.services.EstadoService;

@Service
public class CidadeServiceImpl implements CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private CidadeMapper cidadeMapper;
	
	@Override
	public void cadastrarCidade(CidadeDTO cidadeDTO) {	
		Cidade cidade = cidadeMapper.fromDTO(cidadeDTO);		
		cidade.setEstado(estadoService.findBySigla(cidadeDTO.getEstado().getSigla()));		
		this.cidadeRepository.saveAndFlush(cidade);
	}
	
	@Override
	public Cidade buscarPorNome(String nome) throws NoSuchElementException {
		Optional<Cidade> cidade = cidadeRepository.findByNome(nome);
		if (!cidade.isPresent()) {
			throw new NoSuchElementException("A cidade " + nome + " não existe.");
		}
		return cidade.get();
	}

	@Override
	public CidadeDTO buscarPorNomeDTO(String nome) {
		return cidadeMapper.toDTO(this.buscarPorNome(nome));
	}
	
	@Override
	public Cidade buscarPorNomeAndSiglaEstado(String nome, String siglaEstado) {
		Optional<Cidade> cidade = cidadeRepository.findByNomeAndSiglaEstado(nome, siglaEstado);
		
		if (!cidade.isPresent()) {
			throw new NoSuchElementException("A cidade '" + nome + "' não existe.");		
		}
	
		return cidade.get();	
	}
	
	@Override
	public List<CidadeDTO> buscaCidadePeloNomeEstado(String nome, Integer limite, Integer offset) {
		return CidadeConverter.convertListToDto(cidadeRepository.buscaCidadesPeloNomeEstado(nome, limite < 100 ? limite : 100, offset));
	}
	
	@Override
	public List<CidadeDTO> buscaCidadePelaSiglaEstado(String sigla, Integer limite, Integer offset) {
		return  CidadeConverter.convertListToDto(cidadeRepository.buscaCidadesPelaSiglaEstado(sigla, limite < 100 ? limite : 100, offset));
	}

	@Override
	public void removerCidade(Integer id) {
		if (cidadeRepository.existsById(id)) {
			cidadeRepository.deleteById(id);
		}
	}
}
