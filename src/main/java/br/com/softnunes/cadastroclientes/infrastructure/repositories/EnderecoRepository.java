package br.com.softnunes.cadastroclientes.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.softnunes.cadastroclientes.entities.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

	@Query(value = "SELECT * FROM ENDERECO e"
					+ " WHERE e.CEP = :cep AND e.NUMERO = :numero", nativeQuery = true)
	Optional<Endereco> findByEnderecoPorCepNumero(@Param("cep") String cep,
					@Param("numero") Integer numero);
}
