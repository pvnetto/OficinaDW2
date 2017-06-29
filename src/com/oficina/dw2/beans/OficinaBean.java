package com.oficina.dw2.beans;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.oficina.dw2.entities.Oficina;
import com.oficina.dw2.services.OficinaService;

@Model
public class OficinaBean {
	
	private Oficina oficina = new Oficina();
	@Inject
	private OficinaService oficinaService;
	
	public String GravarOficina(){
		System.out.println("Gravando oficina de CNPJ: " + oficina.getCnpj() + " e nome: " + oficina.getNome());
		
		if(oficina.getCnpj().isEmpty()){
			throw new RuntimeException("CNPJ inválido");
		}
		
		oficinaService.adiciona(oficina);
		
		this.oficina = new Oficina();
		
		return "loginOficina?faces-redirect=true";
	}
	
	public List<Oficina> getOficinas(){
		return oficinaService.listaTodos();
	}

	public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}
	
}
