package com.pac3.model;

import lombok.Data;

@Data
public class Log{

	private boolean retorno;
	private String descricao;
	
	public Log() {}
	
	public Log(boolean retorno, String descricao) {
		this.retorno=retorno;
		this.descricao=descricao;
	}
	
}
