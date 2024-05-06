package com.example.fbtts.entity;

import lombok.Data;

@Data
public class StrategyInfo {

	private long methodUserCount;
	private long methodPublicCount;
	private long methodCount;
	private long userCount;

	private long diffMethodPublicCount;
	private long diffMethodCount;
	private long diffUserCount;

	private double percentMethodPublicCount;
	private double percentMethodCount;
	private double percentUserCount;
	
	public StrategyInfo(long methodUserCount, long methodPublicCount, long methodCount, long userCount,
						long diffMethodPublicCount, long diffMethodCount, long diffUserCount, double percentMethodPublicCount,
						double percentMethodCount, double percentUserCount) {
		
		this.methodUserCount = methodUserCount;
		this.methodPublicCount = methodPublicCount;
		this.methodCount = methodCount;
		this.userCount = userCount;

		this.diffMethodPublicCount = diffMethodPublicCount;
		this.diffMethodCount = diffMethodCount;
		this.diffUserCount = diffUserCount;

		this.percentMethodPublicCount = percentMethodPublicCount;
		this.percentMethodCount = percentMethodCount;
		this.percentUserCount = percentUserCount;
		
	}
	
}
