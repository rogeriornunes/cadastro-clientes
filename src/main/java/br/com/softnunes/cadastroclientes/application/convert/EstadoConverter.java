package br.com.softnunes.cadastroclientes.application.convert;

import br.com.softnunes.cadastroclientes.application.dto.EstadoDTO;
import br.com.softnunes.cadastroclientes.entities.Estado;

public class EstadoConverter {
	
	public static Estado convertToEstado(EstadoDTO estadoDTO) {
		Estado estado = new Estado();
		estado.setNome(estadoDTO.getNome());
		estado.setSigla(estadoDTO.getSigla());
		return estado;
	}
	
	public static EstadoDTO convertToDTO(Estado estado) {
		EstadoDTO estadoDTO = new EstadoDTO();	
		estadoDTO.setNome(estado.getNome());
		estadoDTO.setSigla(estado.getSigla());
		return estadoDTO;
	}	
}
