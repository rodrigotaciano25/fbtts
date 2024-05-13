package com.example.fbtts.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "countries")
public class Country {

	@Transient
	public static final String SEQUENCE_NAME = "country_sequence";

	@Id
	private Long id;
	private String name;
	private String flag;
	
}
