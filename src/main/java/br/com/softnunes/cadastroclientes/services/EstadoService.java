package br.com.softnunes.cadastroclientes.services;

import br.com.softnunes.cadastroclientes.application.dto.EstadoDTO;
import br.com.softnunes.cadastroclientes.entities.Estado;

public interface EstadoService {
	
	void cadastrarEstado(EstadoDTO estadoDTO);
	
	Estado findBySigla(String sigla);
}
