package br.com.softnunes.cadastroclientes.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
	
	public interface CidadeInterfaceDTO {
		Integer getId();
		String getNome();
	}
}
