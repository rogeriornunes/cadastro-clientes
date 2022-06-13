package  br.com.softnunes.cadastroclientes.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.softnunes.cadastroclientes.application.dto.CidadeDTO;
import br.com.softnunes.cadastroclientes.entities.Estado;
import br.com.softnunes.cadastroclientes.services.CidadeService;

@Disabled("Terá que fazer ajuste no teste de integração")
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CidadeControllerTests.class)
public class CidadeControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CidadeService cidadeService;
	
    @Autowired
    private WebApplicationContext webApplicationContext;
    
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void cadastraCidade() throws JsonProcessingException, Exception {
		CidadeDTO cidadeDTO = new CidadeDTO();
		
		cidadeDTO.setNome("Brasília");
		cidadeDTO.setEstado(new Estado(1, "Distrido Federal", "DF"));
		
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/cidades/cadastrar-nova-cidade")
				.content(new ObjectMapper().writeValueAsString(cidadeDTO))
				.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isCreated());  
	}
	
	@Test
	public void buscaCidadePeloNome() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/cidades/buscar-cidade-pelo-nome/Brasília")
				.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk());  
	}
}
