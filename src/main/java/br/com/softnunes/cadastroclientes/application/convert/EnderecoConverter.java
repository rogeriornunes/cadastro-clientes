package br.com.softnunes.cadastroclientes.application.convert;

import br.com.softnunes.cadastroclientes.application.dto.EnderecoDTO;
import br.com.softnunes.cadastroclientes.entities.Endereco;

public class EnderecoConverter {
	
	public static Endereco convertToEndereco(EnderecoDTO enderecoDTO) {
		Endereco endereco = new Endereco();
		endereco.setRua(enderecoDTO.getRua());
		endereco.setCep(enderecoDTO.getCep());
		endereco.setNumero(enderecoDTO.getNumero());
		endereco.setComplemento(enderecoDTO.getComplemento());
		return endereco;
	}
	
	public static EnderecoDTO convertToDTO(Endereco endereco) {
		EnderecoDTO enderecoDTO = new EnderecoDTO();	
		enderecoDTO.setRua(endereco.getRua());
		enderecoDTO.setCep(endereco.getCep());
		enderecoDTO.setNumero(endereco.getNumero());
		enderecoDTO.setComplemento(endereco.getComplemento());
		return enderecoDTO;
	}	
}
