package com.oficina.dw2.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import com.oficina.dw2.entities.Cliente;
import com.oficina.dw2.services.ClienteService;


@Model
public class ClienteBean {
	
	private Cliente cliente = new Cliente();
	@Inject
	private ClienteService clienteService;
	
	public String GravarCliente(){
		System.out.println("Gravando cliente de nome " + cliente.getNome() + " e cpf " + cliente.getId());
		
		if(cliente.getId().isEmpty()){
			//throw new RuntimeException("CPF inválido");
			FacesContext.getCurrentInstance().addMessage("cpf", new FacesMessage("Cliente deve ter um cpf."));
		}
		
		clienteService.adiciona(cliente);
		
		this.cliente = new Cliente();
		
		return "login?faces-redirect=true";
	}
	
	public List<String> getSexos(){
		List<String> sexos = new ArrayList<String>();
		sexos.add("Masculino");
		sexos.add("Feminino");
		
		return sexos;
	}
	
	public List<Cliente> getClientes(){
		return clienteService.listaTodos();
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void ContemCaracteresInvalidos(FacesContext fc, UIComponent component, Object value) throws ValidatorException{
		String valor = value.toString();
		
		if(valor.matches(".*[0123456789;].*")) {
			throw new ValidatorException(new FacesMessage("O campo contém caractéres inválidos."));
		}
	}
	
	@SuppressWarnings("unused")
	private static Calendar parseData(String data) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
}
