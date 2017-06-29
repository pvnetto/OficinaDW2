package com.oficina.dw2.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class MenuBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer index=0;
	
	public Integer getIndex() {
		return index;
	}
	
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public String formCadastroCliente() {
		this.index = 0;
		return "cadastroCliente?faces-redirect=true";
	}
	
	public String formCadastroOficina() {
		this.index = 1;
		return "cadastroOficina?faces-redirect=true";
	}

	public String formLoginCliente() {
		this.index = 2;
		return "login?faces-redirect=true";
	}
	
	public String formLoginOficina() {
		this.index = 3;
		return "loginOficina?faces-redirect=true";
	}
}
