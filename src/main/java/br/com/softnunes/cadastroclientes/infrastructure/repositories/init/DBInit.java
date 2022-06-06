package br.com.softnunes.cadastroclientes.infrastructure.repositories.init;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.softnunes.cadastroclientes.entities.cidade.Cidade;
import br.com.softnunes.cadastroclientes.entities.cliente.Cliente;
import br.com.softnunes.cadastroclientes.entities.estado.Estado;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.CidadeRepository;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.ClienteRepository;
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
			
			if (clienteRepository.count() == 0) {
				Cliente cliente = new Cliente();
				BCryptPasswordEncoder B_CRYPT = new BCryptPasswordEncoder();
				
				// Cadastra Admin
				cliente.setNomeCompleto("Admin");
				cliente.setIsAdmin(true);
				cliente.setSexo(SexoEnum.M);
				cliente.setCidade(this.cidadeRepository.findByNome("Porto Alegre").get());
				cliente.setDataNascimento(new Date());
				cliente.setSenha(B_CRYPT.encode("123456"));
				cliente.setEmail("admin@admin.com.br");
				
				this.clienteRepository.saveAndFlush(cliente);
				
				// Cadastra usuário comum
				cliente = new Cliente();
				
				cliente.setNomeCompleto("Usuário");
				cliente.setIsAdmin(false);
				cliente.setSexo(SexoEnum.M);
				cliente.setCidade(this.cidadeRepository.findByNome("Belo Horizonte").get());
				cliente.setDataNascimento(new Date());
				cliente.setSenha(B_CRYPT.encode("123456"));
				cliente.setEmail("usuario@usuario.com.br");
				
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
