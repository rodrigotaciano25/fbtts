package com.example.fbtts.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class MatchDetail {
	// entidade de um jogo em detalhe, com eventos e estatísticas
	@Transient
	public static final String SEQUENCE_NAME = "detailed_match_sequence";

	@Id
	private Long id;

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
