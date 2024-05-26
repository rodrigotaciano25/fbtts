package com.example.fbtts.model;

import lombok.Data;

@Data
public class Message {

	private String field;
	private String message; // info / warning / error
	
	public Message(String field, String message) {
		this.field = field;
		this.message = message;
	}
	
}
