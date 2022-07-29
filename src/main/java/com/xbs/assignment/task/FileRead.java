package com.xbs.assignment.task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Read any text file and return the number of words repeated in the file and
 * the count of the words
 */
public class FileRead {

	private final String folderPath = "./src/main/resources/";

	private final String fileExtension = ".txt";

	/**
	 * Read from the file and get words and their counts
	 * 
	 * @param fileName
	 */
	public void wordsCountInSentence(String fileName) throws IOException {
		BufferedReader bufferedReader = null;
		try {
			fileName = fileName.endsWith(fileExtension) ? fileName : fileName.trim().concat(fileExtension);
			bufferedReader = new BufferedReader(new FileReader(folderPath + fileName));
			String content = bufferedReader.readLine();
			String[] words = content.split("\\s+");
			Map<String, Integer> totalWords = new HashMap<>();
			for (String word : words) {
				int count = totalWords.getOrDefault(word, 0); // count the word if exists, else 0
				totalWords.put(word, ++count);
			}
			for (String key : totalWords.keySet()) {
				System.out.println(key.trim() + " = " + totalWords.get(key));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Exception: " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		try {
			if (args != null && args.length > 0) {
				String fileName = args[0];
				FileRead fileRead = new FileRead();
				fileRead.wordsCountInSentence(fileName);
			} else {
				System.out.println("Only one argument required");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
