package com.oficina.dw2.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.oficina.dw2.dao.OficinaDAO;
import com.oficina.dw2.entities.Oficina;

@Stateless
public class OficinaService {
	@Inject
	private OficinaDAO oficinaDAO;
	
	public void adiciona(Oficina oficina) {
		oficinaDAO.adiciona(oficina);
	}
	
	public void atualiza(Oficina oficina) {
		oficinaDAO.atualiza(oficina);
	}
	
	public Oficina buscarOficinaPorId(String id) {
		return oficinaDAO.buscaPorId(id);
	}

	public List<Oficina> listaTodos() {
		return oficinaDAO.listaTodos();
	}
	
	public Oficina findOficinaPorLoginESenha(String login, String senha) {
		return oficinaDAO.findOficinaPorLoginESenha(login, senha);
	}
}
