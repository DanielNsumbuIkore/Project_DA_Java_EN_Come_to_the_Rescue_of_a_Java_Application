package com.hemebiotech.analytics;


import java.util.List;
import java.util.TreeMap;

public class Main {
	

	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile file = new ReadSymptomDataFromFile("symptoms.txt");
		AnalyticsCounter counter = new AnalyticsCounter();
		List<String> listOfSymptom = counter.reading(file);
		TreeMap<String, Integer> sort = counter.sorting(listOfSymptom); 
		counter.saving(sort);
		
	}
	
}
