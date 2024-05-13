package com.example.fbtts.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Data
public class Market {
	@Transient
	public static final String SEQUENCE_NAME = "market_sequence";

	@Id
	private Long id;
	private String descr;
	
	private boolean isOperatorMandatory;
	private boolean isValueMandatory;
	
	private String possibleOperator;
	private String possibleValue;
	
}
