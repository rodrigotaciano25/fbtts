package com.example.fbtts.model;

import lombok.Data;

@Data
public class Market {

	private int id;
	private String descr;
	
	private boolean isOperatorMandatory;
	private boolean isValueMandatory;
	
	private String possibleOperator;
	private String possibleValue;
	
}
