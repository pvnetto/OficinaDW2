package com.oficina.dw2.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.oficina.dw2.entities.Cliente;
import com.oficina.dw2.services.ClienteService;
import com.oficina.dw2.util.UserManager;

@Named("userManager")
@RequestScoped
public class ManagedBeanClienteManager implements UserManager {

	@Inject
	private ClienteService clienteService;
	private Cliente novoCliente;
	
	@Override
	@Produces
	@Named
	@RequestScoped
	public List<Cliente> getClientes() {
		return clienteService.listaTodos();
	}
	
	@Override
	public String addUser() {
		clienteService.adiciona(novoCliente);
		
		return "login";
	}
	
	@Override
	public Cliente findCliente(String username, String password) {
		return clienteService.buscaPorEmailESenha(username, password);
	}
	
	@Produces
	@RequestScoped
	@Named
	@Override
	public Cliente getClienteNovo() {
		return this.novoCliente;
	}

}
