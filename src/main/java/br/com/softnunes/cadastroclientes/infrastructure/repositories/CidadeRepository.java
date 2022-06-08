package br.com.softnunes.cadastroclientes.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.softnunes.cadastroclientes.application.dto.CidadeDTO.CidadeInterfaceDTO;
import br.com.softnunes.cadastroclientes.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
	
	@Query(value = "SELECT * FROM CIDADES WHERE NOME = :nome", nativeQuery = true)
	Optional<Cidade> findByNome(@Param("nome") String nome);
	
	@Query(value = "SELECT c.ID, c.NOME FROM CIDADES c"
			+ " INNER JOIN ESTADOS e"
			+ " ON e.ID = c.ESTADO_ID"
			+ " WHERE c.NOME = :nome AND e.SIGLA = :sigla", nativeQuery = true)
	Optional<Cidade> findByNomeAndSiglaEstado(@Param("nome") String nome, @Param("sigla") String sigla);
	
	@Query(value = "SELECT c.ID, c.NOME FROM CIDADES c"
			+ " INNER JOIN ESTADOS e"
			+ " ON e.ID = c.ESTADO_ID"
			+ " WHERE e.NOME = :nome LIMIT :offset, :limite", nativeQuery = true)
	List<CidadeInterfaceDTO> buscaCidadesPeloNomeEstado(@Param("nome") String nome, @Param("limite") Integer limite, @Param("offset") Integer offset);
	
	@Query(value = "SELECT c.ID, c.NOME FROM CIDADES c"
			+ " INNER JOIN ESTADOS e"
			+ " ON e.ID = c.ESTADO_ID"
			+ " WHERE e.SIGLA = :sigla LIMIT :offset, :limite", nativeQuery = true)
	List<CidadeInterfaceDTO> buscaCidadesPelaSiglaEstado(@Param("sigla") String sigla, @Param("limite") Integer limite, @Param("offset") Integer offset);
}
