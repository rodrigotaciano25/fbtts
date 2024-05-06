package com.example.fbtts.entity;

import lombok.Data;

@Data
public class League {
	// Entidade de Competição / Liga
	private Long id;
	private String name;
	private String logo;
	
	private Long countryId;
	
}
