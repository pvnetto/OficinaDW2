package com.oficina.dw2.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.oficina.dw2.dao.MarcaModeloDAO;
import com.oficina.dw2.entities.MarcaModelo;

@Stateless
public class MarcaModeloService {
	@Inject
	private MarcaModeloDAO marcaModeloDAO;
	
	public void Adiciona(MarcaModelo mm) {
		marcaModeloDAO.adiciona(mm);
	}

	public MarcaModelo buscaPorId(Integer marcaModeloId) {
		return marcaModeloDAO.buscaPorId(marcaModeloId);
	}

	public List<MarcaModelo> listaTodos() {
		return marcaModeloDAO.listaTodos();
	}
}
