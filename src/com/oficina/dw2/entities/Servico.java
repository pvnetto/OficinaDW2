package com.oficina.dw2.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

import com.oficina.dw2.enums.EnumStatus;

@Entity
@Table
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id_servico")
	private String idServico;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.MERGE})
	@JoinColumn(name="id_veiculo")
	private Veiculo veiculo;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= CascadeType.MERGE)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name="id_oficina")
	private Oficina oficina;
	
	@Temporal(TemporalType.DATE)
	private Calendar prazoFinal = Calendar.getInstance();
	
	private String descricao;
	
	private EnumStatus statusAtual;

	public Servico() {
		super();
	}

	public String getId() {
		return idServico;
	}

	public void setId(String idServico) {
		this.idServico = idServico;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}

	public Calendar getPrazoFinal() {
		return prazoFinal;
	}

	public void setPrazoFinal(Calendar prazoFinal) {
		this.prazoFinal = prazoFinal;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public EnumStatus getStatusAtual() {
		return statusAtual;
	}

	public void setStatusAtual(EnumStatus statusAtual) {
		this.statusAtual = statusAtual;
	}
	
}
