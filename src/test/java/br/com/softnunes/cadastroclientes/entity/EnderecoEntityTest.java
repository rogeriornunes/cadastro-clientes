package br.com.softnunes.cadastroclientes.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.softnunes.cadastroclientes.entities.Endereco;

public class EnderecoEntityTest {

    @Test
    public void EnderecoTest() {
        Endereco endereco = new Endereco(1, "Rua W2", "74355403", 27, "QD1 LT 15");
        assertEquals("Rua W2", endereco.getRua());
        assertTrue(endereco.toString().contains("Endereco{"));
    }
}