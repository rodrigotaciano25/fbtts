package com.example.fbtts.entity;

import lombok.Data;

import java.util.List;

@Data
public class DashboardMatch {

	private int all; // total league's matches

	private int total; // total filtered matches - bets
	private int wins;

	private double rate; // success rate
	private double oddMin; // minimum odd based on rate
	
	private int count; // matches with odd

	private double profit;
	private double roi;
	
	private double odd; // odd average
	private double oddProfit; // profit calculated match by match - not by average odd

	private List<Match> matches;
	
	private boolean isLive; // the method is live if there is at least one match reference in method 
	
}
