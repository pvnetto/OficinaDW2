package com.oficina.dw2.beans;

import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Named;

import com.oficina.dw2.entities.Oficina;
import com.oficina.dw2.interfaces.OficinaUserManager;
import com.oficina.dw2.services.OficinaService;

@Named("userManagerOficina")
@RequestScoped
@Alternative
@Stateful
public class EJBOficinaManager implements OficinaUserManager{
	
	@Inject
	private OficinaService oficinaService;
	private Oficina newOficina = new Oficina();
	
	@Override
	public List<Oficina> getOficinas() {
		return oficinaService.listaTodos();
	}
	
	@Override
	public String addOficina() {
		oficinaService.adiciona(newOficina);
		return "login";
	}
	
	@Override
	public Oficina findOficina(String email, String senha) {
		return oficinaService.findOficinaPorLoginESenha(email, senha);
	}
	
	@Override
	public Oficina getOficinaNova() {
		return newOficina;
	}
	
}
