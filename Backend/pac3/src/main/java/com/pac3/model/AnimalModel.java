package com.pac3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalModel {
	
	private Long id;
	private String nome;
	private String imagem;
	private String som;
	private String alimentacao;
	private String descricao;
    private Long biomaId;
    
}
