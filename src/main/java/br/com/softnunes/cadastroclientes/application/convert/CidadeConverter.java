package br.com.softnunes.cadastroclientes.application.convert;

import br.com.softnunes.cadastroclientes.application.dto.CidadeDTO;
import br.com.softnunes.cadastroclientes.application.dto.EstadoDTO;
import br.com.softnunes.cadastroclientes.entities.Cidade;
import br.com.softnunes.cadastroclientes.entities.Estado;

public class CidadeConverter {
	
	public static Cidade convertToCidade(CidadeDTO cidadeDTO) {
		Cidade cidade = new Cidade();
		cidade.setNome(cidadeDTO.getNome());
		
		Estado estado = new Estado();
		estado.setNome(cidadeDTO.getEstado().getNome());
		estado.setSigla(cidadeDTO.getEstado().getSigla());
		
		cidade.setEstado(estado);
		return cidade;
	}
	
	public static CidadeDTO convertToDTO(Cidade cidade) {
		CidadeDTO cidadeDTO = new CidadeDTO();
		cidadeDTO.setNome(cidade.getNome());
		
		EstadoDTO estadoDTO = new EstadoDTO();
		estadoDTO.setNome(cidade.getEstado().getNome());
		estadoDTO.setSigla(cidade.getEstado().getSigla());
		
		cidadeDTO.setEstado(estadoDTO);
		return cidadeDTO;
	}	
}
