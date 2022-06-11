package br.com.softnunes.cadastroclientes.services.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softnunes.cadastroclientes.application.dto.EstadoDTO;
import br.com.softnunes.cadastroclientes.entities.Estado;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.EstadoRepository;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.mappers.EstadoMapper;
import br.com.softnunes.cadastroclientes.services.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private EstadoMapper estadoMapper;
	
	@Override
	public void cadastrarEstado(EstadoDTO estadoDTO) {
		estadoRepository.saveAndFlush(estadoMapper.fromDTO(estadoDTO));
	}
	
	@Override
	public Estado findBySigla(String sigla) {
		return estadoRepository.findBySiglaEstado(sigla).orElseGet(() -> {
			throw new NoSuchElementException("Nenhum Estado foi encontrado com a sigla '" + sigla + "'.");
		});
	}
	
	@Override
	public void removerEstado(Integer id) {
		if (estadoRepository.existsById(id)) {
			estadoRepository.deleteById(id);
		}
	}
}
