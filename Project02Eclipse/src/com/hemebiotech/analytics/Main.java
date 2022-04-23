package com.hemebiotech.analytics;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Main {
	

	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile file = new ReadSymptomDataFromFile("symptom.txt");
		List<String> listOfSymptom = new ArrayList<String>();
		listOfSymptom.Reading(file);
		 
		 TreeMap<String, Integer> collection = null;
		 collection = new TreeMap<String, Integer>();
		 collection.Sorting(file);
		 
		 System.out.println(Saving(collection));
	}
	
}
