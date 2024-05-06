package com.example.fbtts.entity;

import lombok.Data;

import java.util.List;

@Data
public class DashboardStrategyTodaysMatch {

	private String date;
	
	private List<DashboardStrategyMatch> matches;
	
}
