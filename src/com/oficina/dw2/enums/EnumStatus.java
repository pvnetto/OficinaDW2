package com.oficina.dw2.enums;

public enum EnumStatus {
	VISTORIA_PENDENTE("Vistoria pendente"),
	AUTORIZACAO_PENDENTE("Autorizacao pendente"),
	SERVICO_AUTORIZADO("Servi�o autorizado"),
	SERVICO_NAO_AUTORIZADO("Servi�o n�o autorizado"),
	AGUARDANDO_PECAS("Aguardando pe�as"),
	AGUARDANDO_CLIENTE("Aguardando cliente"),
	EM_ANDAMENTO("Em andamento"),
	AGUARDANDO_COMPLEMENTO("Aguardando complemento"),
	FINALIZADO("Finalizado"),
	CANCELADO("Cancelado");
	
	private String titulo;
	
	EnumStatus(String titulo){
		this.titulo = titulo;
	}
}
