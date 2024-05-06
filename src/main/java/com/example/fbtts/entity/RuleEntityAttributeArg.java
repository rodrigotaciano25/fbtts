package com.example.fbtts.entity;

import java.util.List;
import lombok.Data;

/**
 *
 *  values: 0.5, 1.5, 2.5 help: isMandatory: true
 *
 *  values: 1, 2, home, away help: isMandatory: false
 * 
 */

@Data
public class RuleEntityAttributeArg {

	private List<String> values;

	private String help;

	private boolean isMandatory;

	public RuleEntityAttributeArg(List<String> values, String help, boolean isMandatory) {
		this.values = values;
		this.help = help;
		this.isMandatory = isMandatory;
	}

}
