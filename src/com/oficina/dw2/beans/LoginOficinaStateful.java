package com.oficina.dw2.beans;

import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.oficina.dw2.entities.Credentials;
import com.oficina.dw2.entities.Oficina;
import com.oficina.dw2.entities.Servico;
import com.oficina.dw2.interfaces.OficinaUserManager;

@Stateful
@ApplicationScoped
@Named
public class LoginOficinaStateful {
	@Inject
	private Credentials userCredentials;
	@Inject
	private OficinaUserManager uManager;
	
	private Oficina oficinaLogada;
	
	public String login() {
		Oficina oficina = uManager.findOficina(userCredentials.getUsername(), userCredentials.getPassword());
		
		if(oficina != null) {
			this.oficinaLogada = oficina;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bem vindo, " + userCredentials.getUsername()));
			return "oficina?faces-redirect=true";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nome de usuário ou senha inválido"));
		return "";
	}
	
	public String Logout() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Flw, " + oficinaLogada.getEmail()));
		oficinaLogada = null;
		return "loginOficina?faces-redirect=true";
	}
	
	public boolean isLoggedIn() {
		return oficinaLogada != null;
	}
	
	@Produces
	public Oficina getOficinaAtual() {
		return oficinaLogada;
	}
	
	public List<Servico> listarServicosPorOficina(){
		return oficinaLogada.getServicos();
	}
}
