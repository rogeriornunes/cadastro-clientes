package  br.com.softnunes.cadastroclientes.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.softnunes.cadastroclientes.application.dto.ClienteDTO;
import br.com.softnunes.cadastroclientes.entities.Cidade;
import br.com.softnunes.cadastroclientes.entities.Estado;
import br.com.softnunes.cadastroclientes.services.ClienteService;
import br.com.softnunes.cadastroclientes.utils.enums.SexoEnum;

@SpringBootTest
public class ClienteControllerTests {
	
	private MockMvc mockMvc;	
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@MockBean
	private ClienteService clienteService;
	
	@BeforeEach
  	public void setUp() {
  		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void criarClienteComTokenAdmin() throws Exception {
		ClienteDTO clienteDTO = new ClienteDTO();
		
		clienteDTO.setNomeCompleto("Teste da Silva Sauro");
		clienteDTO.setEmail("testeint@teste.com");
		clienteDTO.setCidade(new Cidade(null, "São Paulo", new Estado(null, "São Paulo", "SP")));
		clienteDTO.setSexo(SexoEnum.M);
		clienteDTO.setDataNascimento(new Date());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/clientes/novo-cliente")
				.content(new ObjectMapper().writeValueAsString(clienteDTO))
				.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isCreated());  
	}
	
	@Test
	public void criarClienteComTokenNormal() throws Exception {
		ClienteDTO clienteDTO = new ClienteDTO();
		
		clienteDTO.setNomeCompleto("Teste da Silva Sauro");
		clienteDTO.setEmail("testeint@teste.com");
		clienteDTO.setCidade(new Cidade(null, "São Paulo", new Estado(null, "São Paulo", "SP")));
		clienteDTO.setSexo(SexoEnum.M);
		clienteDTO.setDataNascimento(new Date());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/clientes/novo-cliente")
				.content(new ObjectMapper().writeValueAsString(clienteDTO))
				.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isCreated());  
	}
}
