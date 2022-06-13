package br.com.softnunes.cadastroclientes.infrastructure.repositories.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.softnunes.cadastroclientes.application.dto.EnderecoDTO;
import br.com.softnunes.cadastroclientes.entities.Endereco;

@Mapper(
	componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface EnderecoMapper {
	
	EnderecoDTO toDTO(Endereco endereco);
	
	Endereco fromDTO(EnderecoDTO enderecoDTO);
}