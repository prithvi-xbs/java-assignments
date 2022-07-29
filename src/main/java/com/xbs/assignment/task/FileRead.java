package com.xbs.assignment.task;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileRead {

	/**
	 * Get words and their counts
	 * 
	 * @param sentence
	 */
	public void wordsCountInSentence(String sentence) throws IOException {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("./src/main/resources/sentence-read.txt");
			String[] words = sentence.split("\\s+");
			Map<String, Integer> totalWords = new HashMap<>();
			for (String word : words) {
				int count = totalWords.getOrDefault(word, 0);
				totalWords.put(word, ++count);
			}
			System.out.println(totalWords.toString().replace("{", "").replace("}", ""));
		} catch (FileNotFoundException fe) {
			System.out.println("Exception: " + fe.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String sentence = "Hello world is hello   world   is ".toLowerCase();
		FileRead fileRead = new FileRead();
		fileRead.wordsCountInSentence(sentence);
	}

}
