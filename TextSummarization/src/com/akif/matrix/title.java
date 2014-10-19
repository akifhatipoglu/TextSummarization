package com.akif.matrix;

import java.util.ArrayList;
import java.util.List;

import com.akif.datastructure.sentenceStructure;

public class title {
	private List<sentenceStructure> sentenceStructureList;
	private String title;
	
	public title(String title, List<sentenceStructure> sentenceStructureList) {
		this.setSentenceStructureList(sentenceStructureList);
		this.setTitle(title);
	}
	
	public void calculateTitle(){
		int titleCount = 0;
		List<String> stems = new ArrayList<String>();
		for (sentenceStructure sentenceStructure : sentenceStructureList) {
			stems = sentenceStructure.getSentenceRoot();
			titleCount = 0;
			for (String stem: stems) {
				if(this.getTitle().trim().toLowerCase().contains(stem.trim().toLowerCase())){
					titleCount++;
				}
			}
			sentenceStructure.setTitleWordCount(titleCount);
			stems.clear();
		}
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<sentenceStructure> getSentenceStructureList() {
		return sentenceStructureList;
	}
	
	public void setSentenceStructureList(
			List<sentenceStructure> sentenceStructureList) {
		this.sentenceStructureList = sentenceStructureList;
	}
}
