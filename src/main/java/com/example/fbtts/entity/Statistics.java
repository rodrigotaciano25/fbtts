package com.example.fbtts.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Statistics {

	private Map<String, StatisticsLeague> statistics;
	
	@JsonIgnore
	private boolean hasPayments;

	public Statistics() {
		this.statistics = new HashMap<>();
	}
	
	public void init(String id, String league, String logo) {
		StatisticsLeague statisticsLeagueJsonModel = new StatisticsLeague(league, logo);
		this.statistics.putIfAbsent(id, statisticsLeagueJsonModel);
	}
	
	public void addValidMatch(String league, Match match) {
		this.statistics.get(league).addValidMatch(match);
	}

	public void addNoValidMatch(String league, Match match) {
		this.statistics.get(league).addNoValidMatch(match);
		
	}

	public void statistics() {
		
		Collection<StatisticsLeague> values = statistics.values();
		
		for (StatisticsLeague model : values) {
			model.statistics();
		}
		
	}
	
	
	public List<Match> getMatches() {
		
		List<Match> result = new ArrayList<>();
		
		for (StatisticsLeague leagueJsonModel : statistics.values()) {
			result.addAll(leagueJsonModel.getMatches());
			result.addAll(leagueJsonModel.getOthers());
		}
		
		
		Collections.sort(result, new Comparator<Match>() {
			
			@Override
			public int compare(Match o1, Match o2) {
				return o1.getDate().compareTo(o2.getDate());
			};
			
		});

		
		if(!hasPayments) {
			return result.size() < 10 ? result : result.subList(0, 10);
		}
		
		
		return result;
		
	}
	
}
