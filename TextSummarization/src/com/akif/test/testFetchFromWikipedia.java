package com.akif.test;



import java.io.IOException;

import com.akif.fetch.fetchFromWikipedia;

public class testFetchFromWikipedia {
	public static void main(String[] args) {
		fetchFromWikipedia parser = new fetchFromWikipedia("tr");
		try{
			String mainContent = parser.fetchMainContent("Michael Jordan");
			String pageHeading = parser.fetchHeading("atatürk");
			System.out.println("Test Page heading: "+pageHeading);
			System.out.println("Main Content: "+mainContent);
		}catch(IOException ex){
			if(ex.toString().contains("404")){
				System.out.println("404 Page not found , "+ex.getMessage());
			}
			System.exit(0);
		}
	}
}
