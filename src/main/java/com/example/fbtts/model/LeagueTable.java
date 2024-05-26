package com.example.fbtts.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class LeagueTable {
	// Entidade mais complexa de competição / liga
	private String name;
	
	private List<LeagueTableRow> rows;
	
	private List<Match> fixtures;

	private int round;
	private int previous;
	private int next;
	
	private Map<String, Double> goalsMarket;

	private Map<String, Double> goalsMedia;

	private Map<String, Double> results;
	
}
