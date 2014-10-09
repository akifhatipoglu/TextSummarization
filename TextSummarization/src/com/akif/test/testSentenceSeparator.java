package com.akif.test;

import java.io.IOException;
import java.util.List;

import com.akif.fetch.fetchFromWikipedia;
import com.akif.sentence.sentenceSeparator;

public class testSentenceSeparator {
	public static void main(String[] args) {
		testSentenceSeparator sentenceSeparator = new testSentenceSeparator();
		String mainContent = sentenceSeparator.fetchFromWikipedia("atatürk");
		
		sentenceSeparator separator = new sentenceSeparator(mainContent);
		List<String> sentences = separator.getSentence();
		System.out.println("\nSentences:");
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
	}
	public String fetchFromWikipedia(String articleSearch){
		fetchFromWikipedia parser = new fetchFromWikipedia("tr");
		String mainContent = "",pageHeading = "";
		try{
			mainContent = parser.fetchMainContent(articleSearch);
			pageHeading = parser.fetchHeading(articleSearch);
			System.out.println("Test Page heading: "+pageHeading);
			System.out.println("Main Content: "+mainContent);
		}catch(IOException ex){
			if(ex.toString().contains("404")){
				System.out.println("404 Page not found , "+ex.getMessage());
			}
			System.exit(0);
		}
		return mainContent;
	}
}
