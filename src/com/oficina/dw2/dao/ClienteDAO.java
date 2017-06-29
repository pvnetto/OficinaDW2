package com.oficina.dw2.dao;

import java.util.List;

import javax.ejb.Stateless;

import com.oficina.dw2.entities.Cliente;

@Stateless
public class ClienteDAO extends DAO<Cliente> {

	public ClienteDAO() {
		super(Cliente.class);
	}
	
	public Cliente procuraPorEmailESenha(String email, String senha) {
		@SuppressWarnings("unchecked")
		
		List<Cliente> resultados = em.createQuery("select c from Cliente c where c.email =:email and c.senha =:senha")
				.setParameter("email", email).setParameter("senha", senha).getResultList();
		
		if(resultados.isEmpty()) {
			return null;
		}
		
		return resultados.get(0);
	}
	
}
