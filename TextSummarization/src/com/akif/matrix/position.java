package com.akif.matrix;

import java.util.List;

import com.akif.datastructure.sentenceStructure;

public class position {
	private List<sentenceStructure> sentenceStructureList;
	private double one = 1.0;
	
	public position(List<sentenceStructure> sentenceStructure) {
		this.setSentenceStructureList(sentenceStructure);
	}
	
	public void calculatePosition(){
		double positionValue = 0.0 , sentenceLength = 0.0;
		List<sentenceStructure> list = sentenceStructureList;
		for (sentenceStructure sentenceStructure : list) {
			sentenceLength = sentenceStructure.getSenteceID();
			positionValue = this.one/sentenceLength;
			sentenceStructure.setPositionValue(positionValue);
		}
		/*for (sentenceStructure sentenceStructure : list) {
			System.out.println(sentenceStructure.getSentenceLength() +" -- "+sentenceStructure.getPositionValue());
		}*/
	}
	
	
	
	
	public List<sentenceStructure> getSentenceStructureList() {
		return sentenceStructureList;
	}
	public void setSentenceStructureList(
			List<sentenceStructure> sentenceStructureList) {
		this.sentenceStructureList = sentenceStructureList;
	}
	

}
