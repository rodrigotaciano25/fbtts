package com.example.fbtts.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchDetail {
	// entidade de um jogo em detalhe, com eventos e estatísticas
	private Match match;

	private Team home;
	private Team away;
	
	private List<Event> homeEvents;
	private List<Event> awayEvents;

	private Map<String, Statistic> homeStats;
	private Map<String, Statistic> awayStats;
	
	private List<Match> homeResults;
	private List<Match> awayResults;

	private List<Match> homeResultsLast10;
	private List<Match> awayResultsLast10;
	
	private List<H2h> h2h;

	private Map<String, Double> homeGoals;
	private Map<String, Double> awayGoals;

	private Map<String, Double> homeGoalsLast10;
	private Map<String, Double> awayGoalsLast10;
	
	private Map<String, String> odds;
	private HashMap<String, Double> oddsfair;

}
