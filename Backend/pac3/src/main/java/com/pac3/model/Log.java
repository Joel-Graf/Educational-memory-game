package com.pac3.model;

import lombok.Data;

@Data
public class Log{

	private boolean status;
	private String descricao;
	
	public Log() {}
	
	public Log(boolean status, String descricao) {
		this.status=status;
		this.descricao=descricao;
	}
	
}
