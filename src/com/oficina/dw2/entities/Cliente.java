package com.oficina.dw2.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@Column(name="id_cliente")
	private String id;
	
	private String nome;
	private String email;
	private String telefone;
	private String sexo;
	private String senha;
	
	@Column(name = "data_nasc")
	@Temporal(TemporalType.DATE)
	private Calendar dataDeNascimento = Calendar.getInstance();
	
	@OneToMany (fetch=FetchType.EAGER, cascade={CascadeType.MERGE, CascadeType.REMOVE})
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.MERGE, CascadeType.REMOVE})
	private List<Servico> servicos = new ArrayList<Servico>();

	public Cliente() {
		super();
	}
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}   
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return this.telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Calendar getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Calendar dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	public void addVeiculo(Veiculo veiculo){
		this.veiculos.add(veiculo);
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
	
}
