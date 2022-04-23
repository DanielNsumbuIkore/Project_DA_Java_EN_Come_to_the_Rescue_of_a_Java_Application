package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) 
	{
		this.filepath = filepath;
	}
	
	@Override
	public List<String> GetSymptoms() 
	{
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null)
		{
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null)
				{
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	/**
	 * method that reads data from a file
	 *@return dataInput.GetSymptoms() : list of symptoms
	 */
	public List <String> Reading (ReadSymptomDataFromFile dataInput)
	{
		return dataInput.GetSymptoms();	
	}
	
	
	/**
	 * Method Sorting: put the list in alphabetical order count the occurrences of
	 * each symptom in the list.
	 * 
	 * @param list table type of list of symptoms not ordered with duplicates
	 * @return mapSorted: TreeMap including symptoms in alphabetical order and count
	 *         occurrences.
	 */
	public TreeMap<String, Integer> Sorting(List<String> list) {
		Set<String> noDuplicateSet = new HashSet<String>(list); // Delete duplicates
		List<String> noDuplicateList = new ArrayList<String>(noDuplicateSet); // new list without duplicates

		Map<String, Integer> symptomWithOccurrence = new HashMap<String, Integer>(); // Temporary Map to get (symptoms,
																					// occurrence)

		for (String symptom : noDuplicateList) { // fill the Map with symptoms(key) and occurrences(value)
			symptomWithOccurrence.put(symptom, Collections.frequency(list, symptom));
		}

		TreeMap<String, Integer> mapSorted = new TreeMap<String, Integer>(); // TreeMap to sort alphabetically
		mapSorted.putAll(symptomWithOccurrence); // fill the TreeMap with our temporary Map
		return mapSorted;
	}
	
	/**
	 * method that generates a new result.out file listing the symptoms with their occurrences 
	 * @throws IOException 
	 *
	 */
	public void Saving (TreeMap<String, Integer> symptomOccurrence) throws IOException
	{
		FileWriter writer = null;
		try
		{	
			writer = new FileWriter ("result.out"); // method to write to file result.out
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		for(Entry<String, Integer> orh : symptomOccurrence.entrySet()) // the loop allows you to enter the symptom with its number of occurrences
		{
			writer.write(orh.getKey() + "=" + orh.getValue());
		}
		
		writer.close();
	}
	
}
