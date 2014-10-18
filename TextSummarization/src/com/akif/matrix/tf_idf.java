package com.akif.matrix;

import java.util.ArrayList;
import java.util.List;

import zemberek.core.Histogram;

import com.akif.datastructure.sentenceStructure;
import com.akif.datastructure.stemStructure;

public class tf_idf {
	private List<sentenceStructure> sentenceStructureList;
	private int totalNumberOfSentence;
	
	public tf_idf(List<sentenceStructure> list) {
		this.setSentenceStructureList(list);
		totalNumberOfSentence = list.size();
	}
	
	public List<stemStructure> calculateTfIDf(){
		List<String> sentencesStem = new ArrayList<String>();
		List<stemStructure> stemStructeList = new ArrayList<stemStructure>();
		int stemCounter = 0;
		for (sentenceStructure sentenceStructure : sentenceStructureList) {
			System.out.println("\n"+sentenceStructure.getSenteceID()+" --- "+sentenceStructure.getSentence()+" \n-- "+sentenceStructure.getSentenceRoot().toString());
			sentencesStem.addAll(sentenceStructure.getSentenceRoot());
			for (String stem : sentencesStem) {
				stemCounter++;
				System.out.println("--------\n"+stem);
				Histogram<String> histogram = new Histogram<>();
		        histogram.add(sentenceStructure.getSentenceRoot());
		        System.out.println(histogram.size());
		        
		        double tf = calculateTF(histogram, stem);
		        
		        double idf = calculateIDF(stem);
		        
		        double tfIdf = tf*idf;
		        System.out.println("tfidf: "+tfIdf);
		        
		        stemStructure stems = new stemStructure(sentenceStructure.getSenteceID(), stemCounter, stem, tfIdf);
		        stemStructeList.add(stems);
			}
			stemCounter = 0;
			sentencesStem.clear();
		}
		return stemStructeList;
	}
	
	public double calculateTF(Histogram<String> histogram, String stem){
		double countStem = histogram.getCount(stem);
		double countMostStem = histogram.getCount(histogram.getSortedList().get(0));
		double result = countStem/countMostStem;
		System.out.println("countStem:"+countStem+" countMostStem:"+countMostStem+" result:"+result);
		return result;
	}
	
	public double calculateIDF(String stem){
		int number = 0;
		for (sentenceStructure sentenceStructure : sentenceStructureList) {
			Histogram<String> histogram = new Histogram<>();
	        histogram.add(sentenceStructure.getSentenceRoot());
	        
	        int a = histogram.getCount(stem);
			if(a !=0 ){
				number++;
			}
		}
		double numberOfStem = number;
		double total = totalNumberOfSentence;
		double result = Math.log10(total/numberOfStem);
		System.out.println("total:"+total+"stemi içeren cümle sayısı:"+numberOfStem +" result:"+result);
		return result;
	}
	
	public List<sentenceStructure> getSentenceStructureList() {
		return sentenceStructureList;
	}

	public void setSentenceStructureList(
			List<sentenceStructure> sentenceStructureList) {
		this.sentenceStructureList = sentenceStructureList;
	}
}
