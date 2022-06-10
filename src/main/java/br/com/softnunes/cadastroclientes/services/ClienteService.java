package br.com.softnunes.cadastroclientes.services;

import java.util.List;

import br.com.softnunes.cadastroclientes.application.dto.ClienteDTO;

public interface ClienteService {
	
	void novoCliente(ClienteDTO clienteDTO);
	
	void editarCliente(ClienteDTO clienteDTO);
	
	void removerCliente(Integer id);
	
	ClienteDTO buscarClientePorID(Integer id);
	
	ClienteDTO buscarClientePorEmail(String email);
	
	ClienteDTO buscarClientePorNome(String nome);

	ClienteDTO buscarClientePorCpf(String cpf);

	List<ClienteDTO> listaClientes(Integer limite, Integer offset);
}
