package br.com.softnunes.cadastroclientes.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.softnunes.cadastroclientes.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Query(value = "SELECT * FROM CLIENTE WHERE EMAIL = :email", nativeQuery = true)
	Optional<Cliente> findByEmail(@Param("email") String email);
	
	@Query(value = "SELECT * FROM CLIENTE WHERE NOME_COMPLETO = :nomeCompleto", nativeQuery = true)
	Optional<Cliente> findByNomeCompleto(@Param("nomeCompleto") String nomeCompleto);

	@Query(value = "SELECT * FROM CLIENTE WHERE CPF = :cpf", nativeQuery = true)
	Optional<Cliente> findByCpf(@Param("email") String cpf);
}
