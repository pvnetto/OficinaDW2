package com.oficina.dw2.beans;

import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.oficina.dw2.entities.Cliente;
import com.oficina.dw2.entities.Credentials;
import com.oficina.dw2.entities.Veiculo;
import com.oficina.dw2.util.UserManager;

@Stateful
@ApplicationScoped
@Named
public class LoginClienteStateful {
	@Inject
	private Credentials userCredentials;
	@Inject
	private UserManager userManager;
	
	private Cliente clienteAtual;
	
	public String login() {
		Cliente cliente = userManager.findCliente(userCredentials.getUsername(), userCredentials.getPassword());
		
		if(cliente != null) {
			this.clienteAtual = cliente;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bem vindo, " + userCredentials.getUsername()));
			return "cliente?faces-redirect=true";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nome de usuário ou senha inválido"));
		return "";
	}
	
	public String Logout() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Flw, " + clienteAtual.getEmail()));
		clienteAtual = null;
		return "login?faces-redirect=true";
	}
	
	public boolean isLoggedIn() {
		return clienteAtual != null;
	}
	
	@Produces
	public Cliente getClienteAtual() {
		return clienteAtual;
	}
	
	public List<Veiculo> listarVeiculosPorCliente(){
		List<Veiculo> veiculos = userManager.findCliente(clienteAtual.getEmail(), clienteAtual.getSenha()).getVeiculos();
		
		System.out.println("Veículos cadastrados: " + veiculos.size());
		
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getMarcaModelo().getModelo());
		}
		
		//TODO atualizar cliente após adicionar veículo
		
		return veiculos;
	}
	
}
