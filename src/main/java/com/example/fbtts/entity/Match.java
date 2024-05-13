package com.example.fbtts.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "matches")
@Data
public class Match {
	// informações de um determinado jogo
	@Transient
	public static final String SEQUENCE_NAME = "match_sequence";

	@Id
	private Long id;

	private String flag;
	private String country;

	private String logo;
	private String league;
	private String season;
	
	private String date;
	private String time;
	private String status;

	private String round;
	
	private String match;
	private String home;
	private String away;
	
	private String ht;
	private String ft;

	private String odd;
	private String oddFair;
	
	private int winlossignore;
	private boolean follow;

}
