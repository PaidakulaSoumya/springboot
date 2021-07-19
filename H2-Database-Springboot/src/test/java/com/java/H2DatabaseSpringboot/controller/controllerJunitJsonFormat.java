package com.java.H2DatabaseSpringboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class controllerJunitJsonFormat {

	public static String getJsonFormat(Object object) {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonStr = " ";
		if (object != null) {
			try {
				jsonStr = objectMapper.writeValueAsString(object);
			} catch (JsonProcessingException e) {
			}
		}
		return jsonStr;
	}
}


