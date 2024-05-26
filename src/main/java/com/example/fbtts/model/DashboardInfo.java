package com.example.fbtts.model;

import lombok.Data;

@Data
public class DashboardInfo {

	private long methodCount;
	private long countryCount;
	private long leagueCount;
	private long seasonCount;
	
	public DashboardInfo(long methodCount, long countryCount, long leagueCount) {
		this.methodCount = methodCount;
		this.countryCount = countryCount;
		this.leagueCount = leagueCount;
	}
	
	
	public DashboardInfo(long methodCount, long countryCount, long leagueCount, long seasonCount) {
		this.methodCount = methodCount;
		this.countryCount = countryCount;
		this.leagueCount = leagueCount;
		this.seasonCount = seasonCount;
	}
	
}
