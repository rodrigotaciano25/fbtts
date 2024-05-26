package com.example.fbtts.model;

import lombok.Data;

@Data
public class League {
	private Long id;
	private String name;
	private String logo;
	private Long countryId;

	// Construtor
	public League(Long id, String name, String logo, Long countryId) {
		this.id = id;
		this.name = name;
		this.logo = logo;
		this.countryId = countryId;
	}
}
