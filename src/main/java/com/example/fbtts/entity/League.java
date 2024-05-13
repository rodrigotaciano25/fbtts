package com.example.fbtts.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "leaguessimple")
public class League {
	// Entidade de Competição / Liga

	@Transient
	public static final String SEQUENCE_NAME = "league_sequence";

	@Id
	private Long id;
	private String name;
	private String logo;
	
	private Long countryId;
	
}
