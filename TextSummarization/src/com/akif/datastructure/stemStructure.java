package com.akif.datastructure;

public class stemStructure {
	private int sentenceID;
	private int stemID;
	private String stem;
	private double tfidfValue;
		
	public stemStructure(int sentenceID, int stemID, String stem,
			double tfidfValue) {
		this.sentenceID = sentenceID;
		this.stemID = stemID;
		this.stem = stem;
		this.tfidfValue = tfidfValue;
		
	}
	public int getSentenceID() {
		return sentenceID;
	}
	public void setSentenceID(int sentenceID) {
		this.sentenceID = sentenceID;
	}
	public int getStemID() {
		return stemID;
	}
	public void setStemID(int stemID) {
		this.stemID = stemID;
	}
	public String getStem() {
		return stem;
	}
	public void setStem(String stem) {
		this.stem = stem;
	}
	public double getTfidfValue() {
		return tfidfValue;
	}
	public void setTfidfValue(double tfidfValue) {
		this.tfidfValue = tfidfValue;
	}
	
	

}
