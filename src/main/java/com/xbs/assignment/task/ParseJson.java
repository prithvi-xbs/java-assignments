package com.xbs.assignment.task;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseJson {

	/**
	 * To parse a JSON string
	 */
	public void parseJsonString() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("JSON input: ");
		String jsonString = scanner.nextLine();
		String regex = "\\{([^}]+)\\}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(jsonString);
		while (matcher.find()) {
			String token = matcher.group();
			token = token.trim().strip().replace("{", "").replace("\"", "").replace(":", "=").replace("}", "");
			System.out.println("Output: \n" + token);
		}
		scanner.close();
	}

	public static void main(String[] args) {
		ParseJson parseJson = new ParseJson();
		parseJson.parseJsonString();
	}
}
