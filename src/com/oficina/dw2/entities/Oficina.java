package com.oficina.dw2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Oficina implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_oficina")
	private String cnpj;
	
	private String nome;
	private String telefone;
	private String email;
	private String senha;
	
	@OneToMany(mappedBy="oficina", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Servico> servicos = new ArrayList<Servico>();

	public Oficina() {
		super();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	public void addServico(Servico servico) {
		this.servicos.add(servico);
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
