package com.desafio.sistema.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String nome;
	private char sexo;
	private String email;
	private Timestamp dataNascimento; //será obrigatório
	private String naturalidade;
	private String nacionalidade;
	@Column(nullable = false, unique = true)
	private String cpf;

	public Pessoa() {

	}

	public Pessoa(Integer id, String nome, char sexo, String email, Timestamp dataNascimento, String naturalidade,
			String nacionalidade, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.naturalidade = naturalidade;
		this.nacionalidade = nacionalidade;
		this.cpf = cpf;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Timestamp dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", email=" + email + ", dataNascimento="
				+ dataNascimento + ", naturalidade=" + naturalidade + ", nacionalidade=" + nacionalidade + ", cpf="
				+ cpf + "]";
	}

}
