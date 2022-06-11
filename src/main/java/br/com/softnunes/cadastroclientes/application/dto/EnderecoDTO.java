package br.com.softnunes.cadastroclientes.application.dto;

public class EnderecoDTO {

	private Integer id;
	
	private String rua;
	
	private String cep;
	
	private String complemento;
	
	private Integer numero;

	public EnderecoDTO() {}

	public EnderecoDTO(Integer id, String rua, String cep, String complemento, Integer numero) {
		this.id = id;
		this.rua = rua;
		this.cep = cep;
		this.complemento = complemento;
		this.numero = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
