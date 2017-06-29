package com.oficina.dw2.dao;

import javax.ejb.Stateless;

import com.oficina.dw2.entities.MarcaModelo;

@Stateless
public class MarcaModeloDAO extends DAO<MarcaModelo>{

	public MarcaModeloDAO() {
		super(MarcaModelo.class);
	}

}
