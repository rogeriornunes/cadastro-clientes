package  br.com.softnunes.cadastroclientes.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.softnunes.cadastroclientes.application.dto.ClienteDTO;
import br.com.softnunes.cadastroclientes.entities.Cidade;
import br.com.softnunes.cadastroclientes.entities.Endereco;
import br.com.softnunes.cadastroclientes.entities.Estado;
import br.com.softnunes.cadastroclientes.services.ClienteService;
import br.com.softnunes.cadastroclientes.utils.enums.SexoEnum;


@Disabled("Terá que fazer ajuste no teste de integração")
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ClienteControllerTests.class)
public class ClienteControllerTests {
	
	
	@Autowired
	private MockMvc mockMvc;	

	@MockBean
	private ClienteService clienteService;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testNovoCliente() throws Exception {
		ClienteDTO clienteDTO = new ClienteDTO();
		
		clienteDTO.setNomeCompleto("Teste da Joao Paulo");
		clienteDTO.setEmail("testeint@teste.com");
		clienteDTO.setCidade(new Cidade(1, "Goiânia", new Estado(1, "Goiás", "GO")));
		clienteDTO.setEndereco(new Endereco(1, "Rua W2", "74355403", 27, "QD1 LT 15"));
		clienteDTO.setSexo(SexoEnum.M);
		clienteDTO.setCpf("47123889002");
		clienteDTO.setTelefone(123456789L);
		clienteDTO.setDataNascimento(new Date());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/clientes/novo-cliente")
				.content(new ObjectMapper().writeValueAsString(clienteDTO))
				.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isCreated());  
	}
}
