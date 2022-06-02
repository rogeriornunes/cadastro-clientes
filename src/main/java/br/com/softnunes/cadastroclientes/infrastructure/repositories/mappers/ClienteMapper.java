package br.com.softnunes.cadastroclientes.infrastructure.repositories.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.softnunes.cadastroclientes.application.dto.ClienteDTO;
import br.com.softnunes.cadastroclientes.entities.cliente.Cliente;

@Mapper(
	componentModel = "spring", 
	nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ClienteMapper {
	
	@Mapping(target = "senha", ignore = true)
	ClienteDTO toDTO(Cliente clienteEntity);
	
	Cliente fromDTO(ClienteDTO clienteDTO);
}