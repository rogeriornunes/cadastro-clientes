package br.com.softnunes.cadastroclientes.services.impl;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softnunes.cadastroclientes.application.convert.ClienteConverter;
import br.com.softnunes.cadastroclientes.application.dto.ClienteDTO;
import br.com.softnunes.cadastroclientes.entities.Cliente;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.ClienteRepository;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.mappers.ClienteMapper;
import br.com.softnunes.cadastroclientes.services.CidadeService;
import br.com.softnunes.cadastroclientes.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	@Override
	public void novoCliente(ClienteDTO clienteDTO) {
		try {
			if (clienteRepository.findByEmail(clienteDTO.getEmail()).isPresent()) {
				throw new RuntimeException("Já existe um usuário com o mesmo e-mail cadastrado.");
			}
			
			Cliente cliente = this.clienteMapper.fromDTO(clienteDTO);
			
			cliente.setCidade(cidadeService.buscarPorNome(clienteDTO.getCidade().getNome()));
			cliente.setEndereco(enderecoService.buscarPorCepNumero(clienteDTO.getEndereco().getCep(), clienteDTO.getEndereco().getNumero()));
			this.clienteRepository.saveAndFlush(cliente);
			
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar novo cliente: " + e.getMessage());
		}
	}
	
	@Transactional
	@Override
	public void editarCliente(ClienteDTO clienteDTO) {
	
		try {
			Cliente cliente = clienteMapper.fromDTO(clienteDTO);
			
			if (clienteDTO.getCidade() != null && clienteDTO.getCidade().getEstado() != null) {
				cliente.setCidade(cidadeService.buscarPorNomeAndSiglaEstado(clienteDTO.getCidade().getNome(), clienteDTO.getCidade().getEstado().getSigla()));
			}	
			this.clienteRepository.save(cliente);
			
		} catch (Exception e) {
			throw new RuntimeException("Falha ao atualizar o cliente: " + e.getMessage());
		}
	}
	
	@Override
	public void removerCliente(Integer id) {	
		this.clienteRepository.deleteById(id);
	}
	
	@Override
	public ClienteDTO buscarClientePorID(Integer id) {		
		return clienteMapper.toDTO(clienteRepository.findById(id).orElseGet(() -> {
			throw new NoSuchElementException("Nenhum usuário foi encontrado com o ID " + id + ".");
		}));
	}
	
	@Override
	public ClienteDTO buscarClientePorEmail(String email) {	
		return clienteMapper.toDTO(clienteRepository.findByEmail(email).orElseGet(() -> {
			throw new NoSuchElementException("Nenhum usuário foi encontrado com o email: " + email + ".");
		}));
	}
	
	@Override
	public ClienteDTO buscarClientePorNome(String nome) {	
		return clienteMapper.toDTO(clienteRepository.findByNomeCompleto(nome).orElseGet(() -> {
			throw new NoSuchElementException("Nenhum usuário foi encontrado com o nome: " + nome + ".");
		}));
	}

	public ClienteDTO buscarClientePorCpf(String cpf) {
		return clienteMapper.toDTO(clienteRepository.findByCpf(cpf).orElseGet(() -> {
			throw new NoSuchElementException("Nenhum usuário foi encontrado com o CPF " + cpf + ".");
		}));
	}

	@Override
	public List<ClienteDTO> listaClientes(Integer limite, Integer offset) {
		List<Cliente> clientes = clienteRepository.listaClientes(limite < 100 ? limite : 100, offset);
		return ClienteConverter.convertListToDto(clientes);
	}
}
