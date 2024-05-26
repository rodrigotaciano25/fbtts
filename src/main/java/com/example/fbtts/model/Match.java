package com.example.fbtts.model;

import lombok.Data;

@Data
public class Match {
	// informações de um determinado jogo
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
