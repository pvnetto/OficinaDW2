package com.oficina.dw2.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.oficina.dw2.entities.Cliente;
import com.oficina.dw2.entities.MarcaModelo;
import com.oficina.dw2.entities.Veiculo;
import com.oficina.dw2.services.ClienteService;
import com.oficina.dw2.services.MarcaModeloService;
import com.oficina.dw2.services.VeiculoService;

@RequestScoped
@Named
public class VeiculoBean{
	
	private Veiculo veiculo = new Veiculo();
	private String proprietarioId;
	private Integer marcaModeloId;
	
	@Inject
	private ClienteService clienteService;
	@Inject
	private MarcaModeloService marcaModeloService;
	@Inject
	private VeiculoService veiculoService;
	
	public void inserirVeiculo(String id){
		
		if(veiculo.getPlaca().isEmpty()){
			throw new RuntimeException("Placa inválida");
		}
		MarcaModelo marcaModelo = marcaModeloService.buscaPorId(marcaModeloId);
		veiculo.setMarcaModelo(marcaModelo);
		
		Cliente cliente = clienteService.buscaPorId(id);
		
		veiculo.setProprietario(cliente);
		cliente.addVeiculo(veiculo);
		
		clienteService.atualiza(cliente);
		
		this.veiculo = new Veiculo();
	}
	
	public void inserirVeiculo(){
		
		if(veiculo.getPlaca().isEmpty()){
			throw new RuntimeException("Placa inválida");
		}
		MarcaModelo marcaModelo = marcaModeloService.buscaPorId(marcaModeloId);
		veiculo.setMarcaModelo(marcaModelo);
		
		Cliente cliente = clienteService.buscaPorId(proprietarioId);
		
		veiculo.setProprietario(cliente);
		cliente.addVeiculo(veiculo);
		
		clienteService.atualiza(cliente);
		
		this.veiculo = new Veiculo();
	}
	
	public List<MarcaModelo> getMarcasModelos(){
		
		List<MarcaModelo> marcasModelos = marcaModeloService.listaTodos();
		
		if(marcasModelos.size() == 0){


			MarcaModelo marcaModelo0 = new MarcaModelo("Fiat", "Uno");
			MarcaModelo marcaModelo1 = new MarcaModelo("Fiat", "Strada");;
			MarcaModelo marcaModelo4 = new MarcaModelo("VW", "Golf");
			MarcaModelo marcaModelo5 = new MarcaModelo("VW", "Amarok");
			
			marcaModeloService.Adiciona(marcaModelo0);
			marcaModeloService.Adiciona(marcaModelo1);
			marcaModeloService.Adiciona(marcaModelo4);
			marcaModeloService.Adiciona(marcaModelo5);
			
			marcasModelos = marcaModeloService.listaTodos();
			System.out.println("Populando banco de dados MarcaModelo");
		}
		
		return marcasModelos;
	}
	
	public List<Veiculo> getVeiculosProprietario(){
		if(proprietarioId.isEmpty()) {
			return null;
		}
		Cliente cliente = clienteService.buscaPorId(proprietarioId);
		
		return cliente.getVeiculos();
	}
	
	public List<Veiculo> getVeiculosPorIdCliente(String id){
		if(id.isEmpty()) {
			return null;
		}
		
		return veiculoService.buscarPorIdCliente(id);
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Integer getMarcaModeloId() {
		return marcaModeloId;
	}

	public void setMarcaModeloId(Integer marcaModeloId) {
		this.marcaModeloId = marcaModeloId;
	}

	public String getProprietarioId() {
		return proprietarioId;
	}

	public void setProprietarioId(String proprietarioId) {
		this.proprietarioId = proprietarioId;
	}
	
}
