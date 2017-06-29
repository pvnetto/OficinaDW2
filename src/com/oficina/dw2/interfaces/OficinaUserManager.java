package com.oficina.dw2.interfaces;

import java.util.List;
import com.oficina.dw2.entities.Oficina;

public interface OficinaUserManager {
	public List<Oficina> getOficinas();
	
	public String addOficina();
	
	public Oficina findOficina(String email, String senha);
	
	public Oficina getOficinaNova();
}
