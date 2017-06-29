package com.oficina.dw2.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class MenuOficinaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer index=0;
	
	public Integer getIndex() {
		return index;
	}
	
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public String servicosOficina() {
		this.index = 0;
		return "oficina?faces-redirect=true";
	}
	
	public String agendarServicosOficina() {
		this.index = 1;
		return "formAgendamentoOficina?faces-redirect=true";
	}
	
	public String cadastrarVeiculoOficina() {
		this.index = 2;
		return "cadastroVeiculoOficina?faces-redirect=true";
	}
	
}
