package com.example.fbtts.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Method {
	// entidade de uma estratégia
	private Long id;
	
	private String title;
	private String method;
	private List<Long> leagues;
	
	private String market;
	private String operator;
	private String value;
	
	@JsonProperty("isPublic")
	private boolean isPublic;
	
	@JsonProperty("isLive")
	private boolean isLive;
	
	private int total;
	private int wins;
	
	private double odd;
	private double profit;

	private boolean hasMatchesNext;
	
	private String user;
	
	private String dateCreate; // create date
	private String dateUpdate; // last update date
	
	
	// follow data
	
	private int views;
	
	@JsonProperty("isFavorite")
	private boolean isFavorite; // has the user logged in this method as a favorite method 
	
	
	public Method() {
		// do nothing
	}

	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public void setIsLive(boolean isLive) {
		this.isLive = isLive;
	}

	public void setIsFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}
	
}
