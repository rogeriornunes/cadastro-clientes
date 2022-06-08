package br.com.softnunes.cadastroclientes.infrastructure.repositories.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.softnunes.cadastroclientes.application.dto.ClienteDTO;
import br.com.softnunes.cadastroclientes.entities.Cliente;

@Mapper(
	componentModel = "spring", 
	nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ClienteMapper {
	
	ClienteDTO toDTO(Cliente cliente);
	
	Cliente fromDTO(ClienteDTO clienteDTO);
}