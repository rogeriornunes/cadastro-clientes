package br.com.softnunes.cadastroclientes.infrastructure.repositories.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.softnunes.cadastroclientes.application.dto.CidadeDTO;
import br.com.softnunes.cadastroclientes.entities.Cidade;

@Mapper(
	componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CidadeMapper {
	
	CidadeDTO toDTO(Cidade cidadeEntity);
	
	Cidade fromDTO(CidadeDTO cidadeDTO);
}