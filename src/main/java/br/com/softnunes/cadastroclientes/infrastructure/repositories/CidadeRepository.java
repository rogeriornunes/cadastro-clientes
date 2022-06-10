package br.com.softnunes.cadastroclientes.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.softnunes.cadastroclientes.application.dto.CidadeDTO.CidadeInterfaceDTO;
import br.com.softnunes.cadastroclientes.entities.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
	
	@Query(value = "SELECT * FROM CIDADE WHERE NOME_CIDADE = :nomeCidade", nativeQuery = true)
	Optional<Cidade> findByNome(@Param("nomeCidade") String nomeCidade);
	
	@Query(value = "SELECT c.ID_CIDADE, c.NOME_CIDADE FROM CIDADE c"
			+ " INNER JOIN ESTADO e"
			+ " ON e.ID_ESTADO = c.ESTADO_ID"
			+ " WHERE c.NOME_CIDADE = :nomeCidade AND e.SIGLA = :sigla", nativeQuery = true)
	Optional<Cidade> findByNomeAndSiglaEstado(@Param("nomeCidade") String nomeCidade, @Param("sigla") String sigla);
	
	@Query(value = "SELECT c.ID_CIDADE, c.NOME_CIDADE FROM CIDADE c"
			+ " INNER JOIN ESTADO e"
			+ " ON e.ID_ESTADO = c.ESTADO_ID"
			+ " WHERE e.NOME_ESTADO = :nomeEstado LIMIT :offset, :limite", nativeQuery = true)
	List<CidadeInterfaceDTO> buscaCidadesPeloNomeEstado(@Param("nomeEstado") String nomeEstado, @Param("limite") Integer limite, @Param("offset") Integer offset);
	
	@Query(value = "SELECT c.ID_CIDADE, c.NOME_CIDADE FROM CIDADE c"
			+ " INNER JOIN ESTADO e"
			+ " ON e.ID_ESTADO = c.ESTADO_ID"
			+ " WHERE e.SIGLA = :sigla LIMIT :offset, :limite", nativeQuery = true)
	List<CidadeInterfaceDTO> buscaCidadesPelaSiglaEstado(@Param("sigla") String sigla, @Param("limite") Integer limite, @Param("offset") Integer offset);
}
