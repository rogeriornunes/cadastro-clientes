package br.com.softnunes.cadastroclientes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECO")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ENDERECO")
	private Integer id;
	
	@Column()
	private String rua;
	
	@Column()
	private String cep;

	@Column()
	private Integer numero;
	
	@Column()
	private String complemento;
	
	public Endereco() {}
	
	public Endereco(Integer id, String rua, String cep, Integer numero, String complemento) {
		this.id = id;
		this.rua = rua;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	 @Override
	    public String toString() {
	        return "Endereco{" +
	                "id='" + id + '\'' +
	                ", rua=" + rua +
	                ", cep=" + cep +
	                ", complemento='" + complemento + '\'' +
	                '}';
	    }
}
