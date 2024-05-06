package com.example.fbtts.entity;

import lombok.Data;

@Data
public class LeagueTableRow {
	// entidade de uma equipa numa determinada competição / liga
	private Long teamId;
	private String team;
	
	private int points;
	
	private int played;
	
	private int wins;
	private int draws;
	private int losses;
	
	private int scored;
	private int conceded;
	

	public LeagueTableRow(Long teamId, String team) {
		this.teamId = teamId;
		this.team = team;
	}
	
	public int addWins() {
		return ++wins;
	}

	public int addDraws() {
		return ++draws;
	}
	
	public int addLosses() {
		return ++losses;
	}

	public int addScored(int goals) {
		return scored += goals;
	}
	
	public int addConceded(int goals) {
		return conceded += goals;
	}
	
	public int getPoints() {
		points =  this.getWins() * 3 + this.getDraws();
		return points;
	}

	public int getPlayed() {
		played =  this.getWins() + this.getDraws() + this.getLosses();
		return played;
	}
	
}
