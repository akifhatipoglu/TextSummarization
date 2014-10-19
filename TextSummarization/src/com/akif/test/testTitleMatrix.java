package com.akif.test;

import java.io.IOException;
import java.util.List;

import com.akif.datastructure.sentenceStructure;
import com.akif.datastructure.stemStructure;
import com.akif.fetch.fetchFromWikipedia;
import com.akif.lemmantizer.lemmantizer;
import com.akif.matrix.position;
import com.akif.matrix.tf_idf;
import com.akif.sentence.sentenceSeparator;

public class testTitleMatrix {
	public String title;
	
	public static void main(String[] args) {
		//fetch From Wikipedia
		testTitleMatrix test = new testTitleMatrix();
		String mainContent = test.fetchFromWikipedia("muse");
		/*testSentenceSeparator sentenceSeparator = new testSentenceSeparator();
		String mainContent = sentenceSeparator.fetchFromWikipedia("muse");*/
		
		//Sentence Separator
		sentenceSeparator separator = new sentenceSeparator(mainContent);
		List<String> sentences = separator.getSentence();
		System.out.println("\nSentences:");
		for (String sentence : sentences) {
			System.out.println(sentence);
		}
		
		//Setentence Lemmantizer (stemming or root )
		lemmantizer lemma = new lemmantizer(sentences);
		List<sentenceStructure> sentenceStructureList = lemma.getRoot();
		
		for (sentenceStructure sentenceStructure : sentenceStructureList) {
			System.out.println(sentenceStructure.getSenteceID()+" --- "+sentenceStructure.getSentence()+" -- "+sentenceStructure.getSentenceLength()+" -- "+sentenceStructure.getSentenceRoot().toString());
		}
		
		tf_idf tfIdfMatris = new tf_idf(sentenceStructureList);
		List<stemStructure> stemStructure = tfIdfMatris.calculateTfIDf();
		
		for (stemStructure stem : stemStructure) {
			System.out.println("SentenceID: "+stem.getSentenceID()+" stemID:"+stem.getStemID()+" stem:"+stem.getStem()+" tfidf:"+stem.getTfidfValue());
		}
		
		position posMatrix = new position(sentenceStructureList);
		posMatrix.calculatePosition();
		
		for (sentenceStructure sentenceStructure : sentenceStructureList) {
			System.out.println(sentenceStructure.getSenteceID() +" -- "+sentenceStructure.getPositionValue());
		}
		
		
		com.akif.matrix.title titleMatrix = new com.akif.matrix.title(test.title, sentenceStructureList);
		titleMatrix.calculateTitle();
		
		for (sentenceStructure sentenceStructure : sentenceStructureList) {
			System.out.println(sentenceStructure.getSenteceID() +" -- "+sentenceStructure.getSentence()+" -- "+sentenceStructure.getTitleWordCount());
		}
		
	}

	public String fetchFromWikipedia(String articleSearch) {
		fetchFromWikipedia parser = new fetchFromWikipedia("tr");
		String mainContent = "", pageHeading = "";
		try {
			mainContent = parser.fetchMainContent(articleSearch);
			pageHeading = parser.fetchHeading(articleSearch);
			System.out.println("Test Page heading: " + pageHeading);
			title = pageHeading;
			System.out.println("Main Content: " + mainContent);
		} catch (IOException ex) {
			if (ex.toString().contains("404")) {
				System.out.println("404 Page not found , " + ex.getMessage());
			}
			System.exit(0);
		}
		return mainContent;
	}	

}
