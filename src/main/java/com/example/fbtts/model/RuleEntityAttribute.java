package com.example.fbtts.model;

import lombok.Data;

import java.util.List;

@Data
public class RuleEntityAttribute {

	private String attribute;
	
	/*
	 * attribute: Over
	 * arguments: value ; argument
	 * 	
	 * 	values: 0.5, 1.5, 2.5
	 * 	help: 
	 * 	isMandatory: true
	 *
	 * 	values: 1, 2, home, away
	 * 	help: 
	 * 	isMandatory: false
	 * 
	 */
	private List<RuleEntityAttributeArg> args;
	
	private List<String> operators;
	
	
	public RuleEntityAttribute(String attribute, List<RuleEntityAttributeArg> args,List<String> operators) {
		this.attribute = attribute;
		this.args = args;
		this.operators = operators;
	}
	
	public int getArgsCount() {
		return args.size();
	}
	
}
