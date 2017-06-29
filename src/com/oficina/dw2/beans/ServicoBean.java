package com.oficina.dw2.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.oficina.dw2.entities.Cliente;
import com.oficina.dw2.entities.Oficina;
import com.oficina.dw2.entities.Servico;
import com.oficina.dw2.entities.Veiculo;
import com.oficina.dw2.enums.EnumStatus;
import com.oficina.dw2.services.ClienteService;
import com.oficina.dw2.services.OficinaService;
import com.oficina.dw2.services.ServicoService;
import com.oficina.dw2.services.VeiculoService;

@RequestScoped
@ViewScoped
@Named
public class ServicoBean{
	
	private Servico servico = new Servico();
	private String clienteId;
	private String oficinaId;
	private String veiculoId;
	
	@Inject
	private ClienteService clienteservice;
	@Inject
	private OficinaService oficinaService;
	@Inject
	private ServicoService servicoService;
	@Inject
	private VeiculoService veiculoService;
	
	public String agendamentoCliente(String id){
		
		Cliente cliente = clienteservice.buscaPorId(id);
		System.out.println("Cliente encontrado.");
		
		if(cliente == null){
			throw new RuntimeException("Não foi encontrado um cliente com este CPF.");
		}
		
		Oficina oficina = oficinaService.buscarOficinaPorId(oficinaId);
		System.out.println("Oficina encontrada");
		if(oficina == null) {
			throw new RuntimeException("Não foi encontrada uma oficina com este CNPJ.");
		}
		
		Veiculo veiculo = veiculoService.buscarPorId(veiculoId);
		System.out.println("Veículo encontrado.");
		if(veiculo == null) {
			throw new RuntimeException("Não foi encontrado um veículo com esta placa.");
		}
		
		servico.setCliente(cliente);
		System.out.println("Cliente settado.");
		servico.setOficina(oficina);
		System.out.println("Oficina settada.");
		servico.setVeiculo(veiculo);
		System.out.println("Veículo settado.");
		
		cliente.addServico(servico);
		System.out.println("Cliente addado");
		oficina.addServico(servico);
		System.out.println("Oficina addada");
		
		servicoService.adiciona(servico);
		clienteservice.atualiza(cliente);
		oficinaService.atualiza(oficina);
		
		this.servico = new Servico();
		
		return "servicosCliente?faces-redirect=true";
	}
	
	public String agendamentoOficina(String id){
		
		Cliente cliente = clienteservice.buscaPorId(clienteId);
		
		if(cliente == null){
			throw new RuntimeException("Não foi encontrado um cliente com este CPF.");
		}
		
		Oficina oficina = oficinaService.buscarOficinaPorId(id);
		
		if(oficina == null) {
			throw new RuntimeException("Não foi encontrada uma oficina com este CNPJ.");
		}
		
		Veiculo veiculo = null;
		
		List<Veiculo> veiculosCliente = cliente.getVeiculos();
		
		for (Veiculo v : veiculosCliente) {
			if(v.getPlaca() == veiculoId) {
				veiculo = v;
				break;
			}
		}
		
		if(veiculo == null) {
			throw new RuntimeException("Não foi encontrado um veículo com esta placa.");
		}
		
		servico.setCliente(cliente);
		servico.setOficina(oficina);
		servico.setVeiculo(veiculo);
		servico.setStatusAtual(EnumStatus.VISTORIA_PENDENTE);
		
		cliente.addServico(servico);
		oficina.addServico(servico);
		
		servicoService.adiciona(servico);
		clienteservice.atualiza(cliente);
		oficinaService.atualiza(oficina);
		
		this.servico = new Servico();
		
		return "oficina?faces-redirect=true";
	}
	
	public List<Servico> listarServicosPorIdCliente(String id){
		return servicoService.listarServicosPorIdCliente(id);
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getOficinaId() {
		return oficinaId;
	}

	public void setOficinaId(String oficinaId) {
		this.oficinaId = oficinaId;
	}
	
	public String getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(String veiculoId) {
		this.veiculoId = veiculoId;
	}
	
}
