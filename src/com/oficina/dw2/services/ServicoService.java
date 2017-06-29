package com.oficina.dw2.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.oficina.dw2.dao.ServicoDAO;
import com.oficina.dw2.entities.Servico;

@Stateless
public class ServicoService {
	@Inject
	private ServicoDAO servicoDAO;
	
	public void adiciona(Servico servico) {
		servicoDAO.adiciona(servico);
	}

	public List<Servico> listaTodos() {
		return servicoDAO.listaTodos();
	}

	public void atualiza(Servico servico) {
		servicoDAO.atualiza(servico);
	}
	
	public List<Servico> listarServicosPorIdCliente(String id){
		return servicoDAO.listarServicosPorIdCliente(id);
	}
	
}
