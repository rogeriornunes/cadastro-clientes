package br.com.softnunes.cadastroclientes.infrastructure.repositories.init;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.softnunes.cadastroclientes.entities.Cidade;
import br.com.softnunes.cadastroclientes.entities.Cliente;
import br.com.softnunes.cadastroclientes.entities.Endereco;
import br.com.softnunes.cadastroclientes.entities.Estado;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.CidadeRepository;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.ClienteRepository;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.EnderecoRepository;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.EstadoRepository;
import br.com.softnunes.cadastroclientes.utils.LogUtils;
import br.com.softnunes.cadastroclientes.utils.enums.SexoEnum;

/*
 * Esta classe é responsável por inserir dados de testes no banco, caso ele esteja vazio.
 * Usada apenas em teste.
 * Cria 2 instâncias de cada: usuário, estado e cidade.
 */

@Component
public class DBInit {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;	

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@EventListener(ApplicationReadyEvent.class) // Roda este médoto depois que o Spring terminar de inicializar
	public void cadastraDadosFake() {
		int _aux = 0;
		
		try {
			LogUtils.log("Iniciando a criação dos dados fake", "info", this.getClass());
			
			if (estadoRepository.count() == 0) {
				Estado estado = new Estado();
				
				estado.setNome("Minas Gerais");
				estado.setSigla("MG");		
				this.estadoRepository.saveAndFlush(estado);
				
				estado = new Estado();			
				estado.setNome("Rio Grande do Sul");
				estado.setSigla("RS");			
				this.estadoRepository.saveAndFlush(estado);
				
				_aux++;
			}
			
			if (cidadeRepository.count() == 0) {
				Cidade cidade = new Cidade();
				
				cidade.setNome("Belo Horizonte");
				cidade.setEstado(this.estadoRepository.findBySiglaEstado("MG").get());
				
				this.cidadeRepository.saveAndFlush(cidade);
				
				cidade = new Cidade();
				
				cidade.setNome("Porto Alegre");
				cidade.setEstado(this.estadoRepository.findBySiglaEstado("RS").get());
				
				this.cidadeRepository.saveAndFlush(cidade);
				
				_aux++;
			}
			

			if (enderecoRepository.count() == 0) {
				Endereco endereco = new Endereco();
				
				endereco.setRua("W2");
				endereco.setCep("74355502");
				endereco.setNumero(270);
				endereco.setComplemento("QD 1 LT 13");
				this.enderecoRepository.saveAndFlush(endereco);
				
				endereco = new Endereco();
				
				endereco.setRua("27");
				endereco.setCep("74355435");
				endereco.setNumero(0);
				endereco.setComplemento("QD 1 LT 15");
				this.enderecoRepository.saveAndFlush(endereco);
				
				_aux++;
			}
			
			if (clienteRepository.count() == 0) {
				Cliente cliente = new Cliente();	
			
				cliente.setNomeCompleto("Joao Paulo");
				cliente.setSexo(SexoEnum.M);
				cliente.setCidade(this.cidadeRepository.findByNome("Porto Alegre").get());
				cliente.setEndereco(this.enderecoRepository.findByEnderecoPorCepNumero("74355502", 270).get());
				cliente.setDataNascimento(new Date());
				cliente.setEmail("teste@teste.com.br");
				cliente.setCpf("12137274051");
				cliente.setTelefone(1234567897L);
				this.clienteRepository.saveAndFlush(cliente);
				
	
				cliente = new Cliente();
				cliente.setNomeCompleto("Usuário");
				cliente.setSexo(SexoEnum.M);
				cliente.setCidade(this.cidadeRepository.findByNome("Belo Horizonte").get());
				cliente.setEndereco(this.enderecoRepository.findByEnderecoPorCepNumero("74355435", 0).get());
				cliente.setDataNascimento(new Date());
				cliente.setEmail("usuario@usuario.com.br");
				cliente.setCpf("22992044075");
				cliente.setTelefone(1234567895L);
				this.clienteRepository.saveAndFlush(cliente);
				
				_aux++;
			}
			
			if (_aux > 0) {
				LogUtils.log("Criação dos dados fake concluída", "info", this.getClass());
			} else {
				LogUtils.log("Dados fake já existem", "info", this.getClass());
			}
		} catch (Exception e) {
			LogUtils.log("Falha na criação dos dados fake", "alerta", this.getClass());
			LogUtils.log(e.getMessage(), "erro", this.getClass());
		}
	}
}
