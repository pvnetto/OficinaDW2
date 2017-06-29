package com.oficina.dw2.dao;

import java.util.List;

import javax.ejb.Stateless;

import com.oficina.dw2.entities.Oficina;

@Stateless
public class OficinaDAO extends DAO<Oficina>{

	public OficinaDAO() {
		super(Oficina.class);
	}
	
	public Oficina findOficinaPorLoginESenha(String login, String senha) {
		@SuppressWarnings("unchecked")
		
		List<Oficina> resultados = em.createQuery("select o from Oficina o where o.email =:login and o.senha =:senha")
				.setParameter("login", login).setParameter("senha", senha).getResultList();
		
		if(resultados.isEmpty()) {
			return null;
		}
		
		return resultados.get(0);
	}

}
