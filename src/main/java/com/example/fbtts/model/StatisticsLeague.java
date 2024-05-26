package com.example.fbtts.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

@Getter
public class StatisticsLeague {

	
	private String league; // name
	private String logo;

	private int all; // all season matches
	private int verified; // verified matches (win)

	private double rate; // success rate
	private double odd; // minimum odd based on rate
	
	
	/*
	 * Lists for data control. The response will available calculated int and double values.
	 * */
	
	@JsonIgnore
	private List<Match> matches;

	@JsonIgnore
	private List<Match> others;
	
	
	public StatisticsLeague(String league, String logo) {
		this.league = league;
		this.logo = logo;
		this.matches = new ArrayList<>();
		this.others = new ArrayList<>();
	}
	
	public void addValidMatch(Match match) {
		this.matches.add(match);
	}


	public void addNoValidMatch(Match match) {
		this.others.add(match);
	}

	public void statistics() {
		
		this.all = matches.size() + others.size();
		this.verified = matches.size();
		
		if(all == 0) {
			
			this.rate = 0;	
			this.odd = 0;
			
			return;
			
		}
		
		
		this.rate = ((double) verified / (double) all) * 100.0;
		
		if(rate == 0) {
			this.odd = 0;
			return;
		}		
		
		 
		// this.odd = MathUtil.setScale(100.0 / rate);
		
	}
	
}
