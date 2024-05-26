package com.example.fbtts.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Contact {

	@NotEmpty(message = "Please fill the subject.")
	private String subject;
	
	@NotEmpty(message = "Please fill the comments.")
	private String comments;
	
}
