package com.example.fbtts.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "methods")
public class Method {
	@Transient
	public static final String SEQUENCE_NAME = "method_sequence";

	@Id
	private Long id;

	private String title;
	private String method;
	private List<Long> leagues;

	private String market;
	private String operator;
	private String value;

	@JsonProperty("isPublic")
	private boolean isPublic;

	@Setter
	@JsonProperty("isLive")
	private boolean isLive;

	private int total;
	private int wins;

	private double odd;
	private double profit;

	private boolean hasMatchesNext;

	private String user;

	@DBRef
	private List<Match> matches = new ArrayList<>();

	private String dateCreate; // create date
	private String dateUpdate; // last update date

	// follow data
	private int views;

	@Setter
	@JsonProperty("isFavorite")
	private boolean isFavorite; // has the user logged in this method as a favorite method

	public Method() {
		// Do nothing
	}
}
