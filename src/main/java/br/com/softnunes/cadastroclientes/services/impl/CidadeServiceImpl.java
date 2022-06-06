package br.com.softnunes.cadastroclientes.services.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softnunes.cadastroclientes.application.dto.CidadeDTO;
import br.com.softnunes.cadastroclientes.application.dto.CidadeDTO.CidadeInterfaceDTO;
import br.com.softnunes.cadastroclientes.entities.cidade.Cidade;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.CidadeRepository;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.mappers.CidadeMapper;
import br.com.softnunes.cadastroclientes.services.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteServiceImpl clienteService;
	
	@Autowired
	private EstadoServiceImpl estadoServiceImpl;
	
	@Autowired
	private CidadeMapper cidadeMapper;
	
	@Override
	public void cadastrarCidade(CidadeDTO cidadeDTO) {
	
		Cidade cidade = cidadeMapper.fromDTO(cidadeDTO);
		
		cidade.setEstado(estadoServiceImpl.findBySigla(cidadeDTO.getEstado().getSigla()));
		
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
	public List<CidadeInterfaceDTO> buscaCidadePeloNomeEstado(String nome, Integer limite, Integer offset) {
		return cidadeRepository.buscaCidadesPeloNomeEstado(nome, limite < 100 ? limite : 100, offset);
	}
	
	@Override
	public List<CidadeInterfaceDTO> buscaCidadePelaSiglaEstado(String sigla, Integer limite, Integer offset) {
		return cidadeRepository.buscaCidadesPelaSiglaEstado(sigla, limite < 100 ? limite : 100, offset);
	}
}
