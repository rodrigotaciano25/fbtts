package com.example.fbtts.model;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Login {

	@NotEmpty(message = "Please fill the email.")
	@Email(message = "Email is invalid.")
	// @UserIsActiveValid
	private String email;
	
	@NotEmpty(message = "Please fill the password.")
	private String password;

}
