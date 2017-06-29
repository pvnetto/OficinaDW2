package com.oficina.dw2.dao;

import java.util.List;

import javax.ejb.Stateless;

import com.oficina.dw2.entities.Servico;

@Stateless
public class ServicoDAO extends DAO<Servico>{

	public ServicoDAO() {
		super(Servico.class);
	}
	
	public List<Servico> listarServicosPorIdCliente(String id){
		@SuppressWarnings("unchecked")
		List<Servico> resultados = em.createQuery("select s from Servico s where s.cliente.id =:id")
				.setParameter("id", id).getResultList();
		
		if(resultados.isEmpty()) {
			return null;
		}
		
		System.out.println("O cliente " + id + " possui " + resultados.size() + " serviços cadastrados.");
		
		return resultados;
	}
	
}
