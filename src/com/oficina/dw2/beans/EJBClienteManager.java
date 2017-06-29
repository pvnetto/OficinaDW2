package com.oficina.dw2.beans;

import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Named;

import com.oficina.dw2.entities.Cliente;
import com.oficina.dw2.services.ClienteService;
import com.oficina.dw2.util.UserManager;

@Named("userManager")
@RequestScoped
@Alternative
@Stateful
public class EJBClienteManager implements UserManager{

	@Inject
	private ClienteService clienteService;
	private Cliente novoCliente = new Cliente();
	
	@Override
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

	@Override
	public Cliente getClienteNovo() {
		return novoCliente;
	}

}
