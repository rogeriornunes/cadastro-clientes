package br.com.softnunes.cadastroclientes.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.softnunes.cadastroclientes.entities.Endereco;
import br.com.softnunes.cadastroclientes.infrastructure.repositories.EnderecoRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EnderecoRepositoryTest {

	 @Autowired
	    private EnderecoRepository enderecoRepository;

	@Test
	public void insertEndereco() {
		Endereco endereco = new Endereco(1, "Rua W2", "74355403", 27, "QD1 LT 15");
		enderecoRepository.save(endereco);
		Integer countEndereco = enderecoRepository.findAll().size();
		assertTrue(countEndereco == 1);
	}
}
