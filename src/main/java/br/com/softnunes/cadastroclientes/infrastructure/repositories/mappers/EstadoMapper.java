package br.com.softnunes.cadastroclientes.infrastructure.repositories.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.softnunes.cadastroclientes.application.dto.EstadoDTO;
import br.com.softnunes.cadastroclientes.entities.Estado;

@Mapper(
	componentModel = "spring", 
	nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface EstadoMapper {
	
	EstadoDTO toDTO(Estado estadoEntity);
	
	Estado fromDTO(EstadoDTO estadoDTO);
}