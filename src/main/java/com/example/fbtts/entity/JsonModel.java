package com.example.fbtts.entity;

import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Data
public class JsonModel<T> {

	@Setter
    private T response;
	private List<Message> messages; // info / warning / error
	
	public JsonModel() {
		this.messages = new ArrayList<>();
	}

	/*
	public JsonModel(String message) {
		this(StringUtils.EMPTY, message); // field empty -> general error message
	}

	 */

	public JsonModel(String field, String message) {
		this();
		messages.add(new Message(field, message));
	}

	public JsonModel(T response) {
		this();
		this.response = response;
	}

	public JsonModel(List<Message> errors) {
		this.messages = errors;
	}

	public JsonModel(T response, List<Message> errors) {
		this.response = response;
		this.messages = errors;
	}
	
	public void addError(String field, String message) {
		messages.add(new Message(field, message));
	}

	/* public void addError(String message) {
		addError(StringUtils.EMPTY, message);
	}

	 */
}
