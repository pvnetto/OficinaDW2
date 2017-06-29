package com.oficina.dw2.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.oficina.dw2.dao.VeiculoDAO;
import com.oficina.dw2.entities.Veiculo;

@Stateless
public class VeiculoService {
	@Inject
	private VeiculoDAO veiculoDAO;
	
	public void adiciona(Veiculo veiculo) {
		veiculoDAO.adiciona(veiculo);
	}
	
	public Veiculo buscarPorId(String id) {
		return veiculoDAO.buscaPorId(id);
	}
	
	public List<Veiculo> buscarPorIdCliente(String id){
		return veiculoDAO.buscarPorIdCliente(id);
	}
	
}
