package com.oficina.dw2.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Veiculo {
	
	@Id
	@Column (name = "id_veiculo")
	private String placa;
	
	@OneToOne
	private MarcaModelo marcaModelo;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_cliente")
	private Cliente proprietario;
	
	public Veiculo(){
		super();
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public MarcaModelo getMarcaModelo() {
		return marcaModelo;
	}
	public void setMarcaModelo(MarcaModelo marcaModelo) {
		this.marcaModelo = marcaModelo;
	}
	public Cliente getProprietario() {
		return proprietario;
	}
	public void setProprietario(Cliente proprietario) {
		this.proprietario = proprietario;
	}
	
	@Override
	public String toString() {
		return marcaModelo + " " + placa;
	}
	
}
