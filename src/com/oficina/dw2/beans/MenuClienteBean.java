package com.oficina.dw2.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class MenuClienteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer index=0;
	
	public Integer getIndex() {
		return index;
	}
	
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public String veiculosCliente() {
		this.index = 0;
		return "cliente?faces-redirect=true";
	}
	
	public String servicosCliente() {
		this.index = 1;
		return "servicosCliente?faces-redirect=true";
	}
	
	public String formVeiculoCliente() {
		this.index = 2;
		return "cadastroVeiculoCliente?faces-redirect=true";
	}

	public String formAgendamentoCliente() {
		this.index = 3;
		return "formAgendamentoCliente?faces-redirect=true";
	}
}
