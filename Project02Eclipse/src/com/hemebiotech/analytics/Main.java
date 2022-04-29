package com.hemebiotech.analytics;


import java.util.List;
import java.util.TreeMap;

public class Main {
	

	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile file = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> listOfSymptom = file.Reading(file);
		TreeMap<String, Integer> sort = file.Sorting(listOfSymptom); 
		file.Saving(sort);
		
	}
	
}
