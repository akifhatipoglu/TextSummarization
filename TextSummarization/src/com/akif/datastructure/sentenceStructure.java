package com.akif.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class sentenceStructure {
	
	private String[] stepWordArray = new String[] { "acaba", "altı", "ama",
			"ancak", "artık", "asla", "aslında", "az", "bana", "bazen", "bazı",
			"bazıları", "bazısı", "belki", "ben", "beni", "benim", "beş",
			"bile", "bir", "birçoğu", "birçok", "birçokları", "biri", "birisi",
			"birkaç", "birkaçı", "birşey", "birşeyi", "biz", "bize", "bizi",
			"bizim", "böyle", "böylece", "bu", "buna", "bunda", "bundan",
			"bunu", "bunun", "burada", "bütün", "çoğu", "çoğuna", "çoğunu",
			"çok", "çünkü", "da", "daha", "de", "değil", "demek", "diğer",
			"diğeri", "diğerleri", "diye", "dokuz", "dolayı", "dört",
			"elbette", "en", "fakat", "falan", "felan", "filan", "gene",
			"gibi", "hâlâ", "hangi", "hangisi", "hani", "hatta", "hem",
			"henüz", "hep", "hepsi", "hepsine", "hepsini", "her", "her biri",
			"herkes", "herkese", "herkesi", "hiç", "hiç kimse", "hiçbiri",
			"hiçbirine", "hiçbirini", "için", "içinde", "iki", "ile", "ise",
			"işte", "kaç", "kadar", "kendi", "kendine", "kendini", "ki", "kim",
			"kime", "kimi", "kimin", "kimisi", "madem", "mı", "mı", "mi", "mu",
			"mu", "mü", "mü", "nasıl", "ne", "ne kadar", "ne zaman", "neden",
			"nedir", "nerde", "nerede", "nereden", "nereye", "nesi", "neyse",
			"niçin", "niye", "on", "ona", "ondan", "onlar", "onlara",
			"onlardan", "onların", "onların", "onu", "onun", "orada", "oysa",
			"oysaki", "öbürü", "ön", "önce", "ötürü", "öyle", "rağmen", "sana",
			"sekiz", "sen", "senden", "seni", "senin", "siz", "sizden", "size",
			"sizi", "sizin", "son", "sonra", "şayet", "şey", "şeyden", "şeye",
			"şeyi", "şeyler", "şimdi", "şöyle", "şu", "şuna", "şunda",
			"şundan", "şunlar", "şunu", "şunun", "tabi", "tamam", "tüm",
			"tümü", "üç", "üzere", "var", "ve", "veya", "veyahut", "ya",
			"ya da", "yani", "yedi", "yerine", "yine", "yoksa", "zaten", "zira" };
	
	private HashSet<String> stepWordHash = new HashSet<String>(
			Arrays.asList(stepWordArray));
	private String sentence;
	private int senteceID;
	private List<String> sentenceRoot = new ArrayList<String>(); // all root in
																	// the
																	// sentence
	private int sentenceLength;
	private double positionValue;
	private int titleWordCount;
	
	public sentenceStructure(int sentenceID, String sentence,
			List<String> sentenceRoot) {
		this.setSenteceID(sentenceID);
		this.setSentence(sentence);
		this.setSentenceRoot(sentenceRoot);
		this.setPositionValue(0);
	}

	public boolean isStepWords(String root) {
		return stepWordHash.contains(root);
	}

	public int getSenteceID() {
		return senteceID;
	}

	public void setSenteceID(int senteceID) {
		this.senteceID = senteceID;
	}
	public int getSentenceLength() {
		return sentenceLength;
	}
	public void setSentenceLength(int sentenceLength) {
		this.sentenceLength = sentenceLength;
	}
	public String getSentence() {
		return sentence;
	}

	public List<String> getSentenceRoot() {
		return sentenceRoot;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	public double getPositionValue() {
		return positionValue;
	}
	public void setPositionValue(double positionValue) {
		this.positionValue = positionValue;
	}
	public int getTitleWordCount() {
		return titleWordCount;
	}
	public void setTitleWordCount(int titleWordCount) {
		this.titleWordCount = titleWordCount;
	}

	public void setSentenceRoot(List<String> sentenceRoot) {
		List<String> list = sentenceRoot;
		this.sentenceRoot.addAll(list);
		for (String root : list) {
			if (root.matches("\\p{Punct}")) {
				this.sentenceRoot.remove(root);
			} else {
				if (isStepWords(root)) {
					this.sentenceRoot.remove(root);
				} else {
					// Step word değil
				}
			}
		}
		this.setSentenceLength(this.sentenceRoot.size());// sentence length (number of stem word)
	}

}
