package br.com.softnunes.cadastroclientes.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.softnunes.cadastroclientes.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
	
	@Query(value = "SELECT * FROM ESTADO LIMIT 1", nativeQuery = true)
	Optional<Estado> findOne();
	
	@Query(value = "SELECT * FROM ESTADO WHERE SIGLA = :sigla", nativeQuery = true)
	Optional<Estado> findBySiglaEstado(@Param("sigla") String sigla);
}
