package com.akif.sentence;

import java.util.List;

import zemberek.tokenizer.SentenceBoundaryDetector;
import zemberek.tokenizer.SimpleSentenceBoundaryDetector;

public class sentenceSeparator {
	private String mainContent;
	
	public sentenceSeparator(String mainContent) {
		this.setMainContent(mainContent);
	}

	//Sentence boundary detection, main Content to many sentences
	public List<String> getSentence() {
		SentenceBoundaryDetector detector = new SimpleSentenceBoundaryDetector();
        List<String> sentences = detector.getSentences(this.getMainContent());
		return sentences;
	}
	
	public String getMainContent() {
		return mainContent;
	}

	public void setMainContent(String mainContent) {
		this.mainContent = mainContent;
	}

}
