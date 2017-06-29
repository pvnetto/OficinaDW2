package com.oficina.dw2.dao;

import java.util.List;

import javax.ejb.Stateless;

import com.oficina.dw2.entities.Veiculo;

@Stateless
public class VeiculoDAO extends DAO<Veiculo>{

	public VeiculoDAO() {
		super(Veiculo.class);
	}
	
	public List<Veiculo> buscarPorIdCliente(String id) {
		@SuppressWarnings("unchecked")
		List<Veiculo> resultados = em.createQuery("select v from Veiculo v where v.proprietario.id =:id")
				.setParameter("id", id).getResultList();
		
		if(resultados.isEmpty()) {
			return null;
		}
		
		System.out.println("O cliente " + id + " possui " + resultados.size() + " veículos cadastrados.");
		
		return resultados;
	}

}
