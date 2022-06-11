package br.com.softnunes.cadastroclientes.application.convert;

import java.util.List;
import java.util.stream.Collectors;

import br.com.softnunes.cadastroclientes.application.dto.CidadeDTO;
import br.com.softnunes.cadastroclientes.application.dto.ClienteDTO;
import br.com.softnunes.cadastroclientes.application.dto.EnderecoDTO;
import br.com.softnunes.cadastroclientes.application.dto.EstadoDTO;
import br.com.softnunes.cadastroclientes.entities.Cidade;
import br.com.softnunes.cadastroclientes.entities.Cliente;
import br.com.softnunes.cadastroclientes.entities.Endereco;
import br.com.softnunes.cadastroclientes.entities.Estado;

public class ClienteConverter {
	
	public static Cliente convertToCidade(ClienteDTO clienteDTO) {
		
		Cliente cliente = new Cliente();
		cliente.setNomeCompleto(clienteDTO.getNomeCompleto());
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setDataNascimento(clienteDTO.getDataNascimento());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setIdade(clienteDTO.getIdade());
		cliente.setSexo(clienteDTO.getSexo());
		cliente.setTelefone(clienteDTO.getTelefone());
		
		Endereco endereco = new Endereco();
		endereco.setRua(clienteDTO.getEndereco().getRua());
		endereco.setCep(clienteDTO.getEndereco().getCep());
		endereco.setNumero(clienteDTO.getEndereco().getNumero());
		endereco.setComplemento(clienteDTO.getEndereco().getComplemento());
		
		Cidade cidade = new Cidade();
		cidade.setNome(clienteDTO.getCidade().getNome());
		
		Estado estado = new Estado();
		estado.setNome(clienteDTO.getCidade().getEstado().getNome());
		estado.setSigla(clienteDTO.getCidade().getEstado().getSigla());
		
		cliente.setEndereco(endereco);
		cidade.setEstado(estado);
		cliente.setCidade(cidade);
		return cliente;
	}
	
	public static ClienteDTO convertToDTO(Cliente cliente) {
		
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setNomeCompleto(cliente.getNomeCompleto());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setDataNascimento(cliente.getDataNascimento());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setIdade(cliente.getIdade());
		clienteDTO.setSexo(cliente.getSexo());
		clienteDTO.setTelefone(cliente.getTelefone());
		
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.setRua(cliente.getEndereco().getRua());
		enderecoDTO.setCep(cliente.getEndereco().getCep());
		enderecoDTO.setNumero(cliente.getEndereco().getNumero());
		enderecoDTO.setComplemento(cliente.getEndereco().getComplemento());
		
		CidadeDTO cidadeDTO = new CidadeDTO();
		cidadeDTO.setNome(cliente.getCidade().getNome());
		
		EstadoDTO estadoDTO = new EstadoDTO();
		estadoDTO.setNome(cliente.getCidade().getEstado().getNome());
		estadoDTO.setSigla(cliente.getCidade().getEstado().getSigla());
		return clienteDTO;
	}

	public static List<ClienteDTO> convertListToDto(List<Cliente> clientes) {
		List<ClienteDTO> listClienteDTO = clientes.stream()
						.map(cliente -> new ClienteDTO(cliente.getId(), cliente.getNomeCompleto(),
										cliente.getEmail(), cliente.getSexo(),
										cliente.getDataNascimento(), cliente.getCidade(),
										cliente.getTelefone(), cliente.getCpf(), cliente.getIdade(),
										cliente.getEndereco()))
						.collect(Collectors.toList());
		return listClienteDTO;

	}
}
