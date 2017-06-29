package com.oficina.dw2.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.oficina.dw2.dao.ClienteDAO;
import com.oficina.dw2.entities.Cliente;

@Stateless
public class ClienteService {
	@Inject
	private ClienteDAO clienteDAO;
	
	public void adiciona(Cliente cliente) {
		clienteDAO.adiciona(cliente);
	}

	public List<Cliente> listaTodos() {
		return clienteDAO.listaTodos();
	}
	
	public Cliente buscaPorEmailESenha(String email, String senha) {
		return clienteDAO.procuraPorEmailESenha(email, senha);
	}

	public Cliente buscaPorId(String id) {
		return clienteDAO.buscaPorId(id);
	}

	public void atualiza(Cliente cliente) {
		clienteDAO.atualiza(cliente);
	}
}
