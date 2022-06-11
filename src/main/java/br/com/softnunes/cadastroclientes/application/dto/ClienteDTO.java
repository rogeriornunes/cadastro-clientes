package br.com.softnunes.cadastroclientes.application.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.softnunes.cadastroclientes.entities.Cidade;
import br.com.softnunes.cadastroclientes.entities.Endereco;
import br.com.softnunes.cadastroclientes.utils.enums.SexoEnum;

@JsonInclude(Include.NON_NULL)
public class ClienteDTO {
	
	private Integer id;
	
	private String nomeCompleto;
	
	private String email;
	
	private SexoEnum sexo; 
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	private Long telefone;
	
	private String cpf;
	
	private Integer idade;
	
	private Cidade cidade;
	
	private Endereco endereco;
	
	public ClienteDTO() {}

	public ClienteDTO(Integer id, String nomeCompleto, String email, SexoEnum sexo,
					Date dataNascimento, Cidade cidade, Integer telefone, String cpf) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
	}

	public ClienteDTO(Integer id, String nomeCompleto, String email, SexoEnum sexo,
					Date dataNascimento, Cidade cidade, Long telefone, String cpf,
					Integer idade, Endereco endereco) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
		this.telefone = telefone;
		this.cpf = cpf;
		this.idade = idade;
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}	
	
	

	

