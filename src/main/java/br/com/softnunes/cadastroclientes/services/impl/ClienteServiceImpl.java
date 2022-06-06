package br.com.softnunes.cadastroclientes.services.impl;

import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.softnunes.cadastroclientes.application.dto.ClienteDTO;
import br.com.softnunes.cadastroclientes.entities.cliente.Cliente;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.ClienteRepository;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.mappers.ClienteMapper;
import br.com.softnunes.cadastroclientes.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CidadeServiceImpl cidadeService;
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	private final BCryptPasswordEncoder B_CRIPT = new BCryptPasswordEncoder();
	
	@Override
	public void novoCliente(ClienteDTO clienteDTO) {
		try {
			if (clienteRepository.findByEmail(clienteDTO.getEmail()).isPresent()) {
				throw new RuntimeException("Já existe um usuário com o mesmo e-mail cadastrado.");
			}
			
			Cliente clienteEntity = this.clienteMapper.fromDTO(clienteDTO);
			
			clienteEntity.setCidade(cidadeService.buscarPorNomeAndSiglaEstado(clienteDTO.getCidade().getNome(), clienteDTO.getCidade().getEstado().getSigla()));
			clienteEntity.setSenha(B_CRIPT.encode(clienteDTO.getSenha()));
			
			this.clienteRepository.saveAndFlush(clienteEntity);
			
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
			
			if (clienteDTO.getSenha() != null) {
				cliente.setSenha(B_CRIPT.encode(clienteDTO.getSenha()));
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
}
