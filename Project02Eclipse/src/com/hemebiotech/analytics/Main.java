package com.hemebiotech.analytics;


import java.util.List;
import java.util.TreeMap;

/**
 *  From the file symptoms.txt  
 *  the Main class generates a result.out file
 *  with its symptoms and occurrences
 *  in alphabetical order  
 */

public class Main {
	

	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile file = new ReadSymptomDataFromFile("symptoms.txt"); // Instantiates the ReadSymptomDataFromFile class 
		AnalyticsCounter counter = new AnalyticsCounter();							// Instantiates the AnalyticsCounter class
		List<String> listOfSymptom = counter.reading(file);							// Read the file and return a list of symptoms
		TreeMap<String, Integer> sort = counter.sorting(listOfSymptom); 			// Outputs a collection of symptoms with their occurrences in alphabetical order
		counter.saving(sort);														// Generates a result.out file with the symptoms and their occurrences written on it
		
	}
	
}
