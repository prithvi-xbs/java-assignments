package com.xbs.assignment.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseJson {

	String jsonString = "{\"name\": \"sarah\", \"age\": 23, \"date\": \"29-07-2022\" }";

	/**
	 * To parse a JSON string
	 */
	public void parseJsonString() {
		String regex = "\\{([^}]+)\\}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(jsonString);
		while (matcher.find()) {
			String token = matcher.group();
			token = token.trim().strip().replace("{", "").replace("\"", "").replace(":", "=").replace("}", "");
			System.out.println(token);
		}
	}

	public static void main(String[] args) {
		ParseJson parseJson = new ParseJson();
		parseJson.parseJsonString();
	}
}
