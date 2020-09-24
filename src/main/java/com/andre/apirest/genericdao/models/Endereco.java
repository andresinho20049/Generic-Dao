package com.andre.apirest.genericdao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(length = 50, nullable = false)
	private String logradouro;
	
	@Column(length = 10, nullable = false)
	private Integer numero;
	
	@Column(length = 50, nullable = false)
	private String bairro;

	@Column(length = 50, nullable = false)
	private String municipio;

	@Column(length = 2, nullable = false)
	private String uf;

	@Column(length = 8, nullable = false)
	private Integer cep;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

}
