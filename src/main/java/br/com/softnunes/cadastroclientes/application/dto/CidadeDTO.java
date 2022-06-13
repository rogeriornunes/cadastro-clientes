package br.com.softnunes.cadastroclientes.application.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.softnunes.cadastroclientes.entities.Cidade;
import br.com.softnunes.cadastroclientes.entities.Estado;

@JsonInclude(Include.NON_NULL)
public class CidadeDTO {
	
	private Integer id;
	
	private String nome;
	
	private Estado estado;
	
	public CidadeDTO() {}

	public CidadeDTO(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public CidadeDTO(Integer id, String nome, Estado estado) {
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public List<CidadeDTO> convertListToDto(List<Cidade> cidades) {
		List<CidadeDTO> listCidadeDTO = cidades.stream()
						.map(cidade -> new CidadeDTO(cidade.getId(), cidade.getNome()))
						.collect(Collectors.toList());
		return listCidadeDTO;
	}
	
	public interface CidadeInterfaceDTO {
		Integer getId();
		String getNome();
	}
}
