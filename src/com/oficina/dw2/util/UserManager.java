package com.oficina.dw2.util;

import java.util.List;

import com.oficina.dw2.entities.Cliente;
import com.oficina.dw2.entities.Veiculo;

public interface UserManager {
	public List<Cliente> getClientes();
	
	public String addUser();
	
	public Cliente findCliente(String username, String password);
	
	public Cliente getClienteNovo();
	
}
