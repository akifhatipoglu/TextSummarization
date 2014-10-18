package com.akif.lemmantizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.akif.datastructure.sentenceStructure;

import zemberek.morphology.ambiguity.Z3MarkovModelDisambiguator;
import zemberek.morphology.apps.TurkishMorphParser;
import zemberek.morphology.apps.TurkishSentenceParser;
import zemberek.morphology.parser.MorphParse;
import zemberek.morphology.parser.SentenceMorphParse;

public class lemmantizer {
	private List<String> sentences;
	
	public lemmantizer(List<String> sentences) {
		this.sentences = sentences;
	}
	
	
	
	public List<sentenceStructure> getRoot(){
		List<sentenceStructure> sentenceStructureList = new ArrayList<sentenceStructure>();
		try {
			TurkishMorphParser morphParser = TurkishMorphParser.createWithDefaults();
			Z3MarkovModelDisambiguator disambiguator = new Z3MarkovModelDisambiguator();
			TurkishSentenceParser sentenceParser = new TurkishSentenceParser(
	                morphParser,
	                disambiguator
	        );
			int sentenceID = 0;
			List<String> roots = new ArrayList<String>();
			for (String sentence : sentences) {
				SentenceMorphParse sentenceParse = sentenceParser.parse(sentence);
				sentenceParser.disambiguate(sentenceParse);
				int counter = 0;
				for (SentenceMorphParse.Entry entry : sentenceParse) {
					System.out.println("Word = " + entry.input);
					counter=0;
					for (MorphParse parse : entry.parses) {
						if(counter == 0) {
							System.out.println("root:"+parse.root);
							System.out.println("id: "+sentenceID+" entry: "+sentence+" root: "+parse.root);
							roots.add(parse.root);
							
						}
						counter++;
					}
				}
				sentenceID++;
				System.out.println(roots.toString());
				System.out.println();
				sentenceStructure structure = new sentenceStructure(sentenceID, sentence,roots);
				sentenceStructureList.add(structure);
				roots.clear();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sentenceStructureList;
	}
	
	
	public List<String> getSentences() {
		return sentences;
	}
	public void setSentences(List<String> sentences) {
		this.sentences = sentences;
	}
}
