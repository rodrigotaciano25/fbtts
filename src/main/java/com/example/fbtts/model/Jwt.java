package com.example.fbtts.model;

import lombok.Data;

import java.util.List;

@Data
public class Jwt {

	private String token;
	private String type = "fbtts";
	private String id;
	private String email;
	private String name;
	
	private int clicks;
	private boolean hasPayments;
	
	private String language;
	private String currency;
	
	private List<String> roles;
	
}
