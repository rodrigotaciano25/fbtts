package com.example.fbtts.model;

import lombok.Data;

@Data
public class DashboardTranslate {

	private int code; // 0 OK, -1 ERROR
	private String message;
	
}
