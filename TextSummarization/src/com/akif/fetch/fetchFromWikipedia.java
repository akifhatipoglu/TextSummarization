package com.akif.fetch;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class fetchFromWikipedia {
	private  String baseUrl;
	
	public fetchFromWikipedia(String lang) {
		this.setBaseUrl(String.format("http://%s.wikipedia.org/wiki/", lang));
	}
	
	//fetch from wikipedia : fetch page heading
	public String fetchHeading(String article) throws IOException {
		String url = baseUrl + article;
		Document doc = Jsoup.connect(url).get();
		Elements headingElements = doc.select("#firstHeading");
		Element pageHeading = headingElements.first();
		String heading = pageHeading.text();
		return heading;
	}
	
	//fetch from wikipedia : fetch page main content
	public String fetchMainContent(String article) throws IOException {
		String url = baseUrl + article;
		Document doc = Jsoup.connect(url).get();
		Elements paragraphs = doc.select(".mw-content-ltr p,.mw-content-ltr h2 ,.mw-content-ltr h3");
		System.out.println("****\tParagraph separation began.\t*****\n");
		int i = 1;
		String mainContent = "";
		for(Element value: paragraphs){
			if(!value.text().isEmpty()){
				String value1 = value.text().replaceAll("(\\[+[0-9]*\\]+)", "");
				if(value1.contains("[değiştir | kaynağı değiştir]")){
					value1 = value1.replace("[değiştir | kaynağı değiştir]", "");
				}
				System.out.println(value.tagName()+" "+i+"-"+value1);
				if(value.tagName().equals("p")){
					mainContent += value1;
				}else{
					break;
				}	
			}else{
				System.out.println(" "+i+"-"+"This paragraph is emnty!");
			}
			i++;
			System.out.println();
	    }
		System.out.println("****\tParagraph separation over.\t*****\n");
		return mainContent;
	}
		
	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
}
