package com.json.lib.main;

import java.util.Map;
import java.util.Collections;
import java.util.HashMap;

public class JSONTwo {
	final private String COMMA = ",";
	final private String START = "{";
	final private String END = "}";
	final private String COLON = ":";
	final private String QUOTE = "\"";
	
	// To store all key-value pair in a map internally
	private Map<String, Object> objectsMap;
	
	// Create an empty JSON Object
	public JSONTwo() {
		objectsMap = new HashMap<String, Object>();
	}
	
	// Create a JSON Object with the key-value pair of a map object passed as parameter in the constructor
	public JSONTwo(Map<String, Object> map) {
		objectsMap = new HashMap<String, Object>();
		this.objectsMap.putAll(map);
	}
	
	// TO get the number of key-value pair in the map
	int size() { return objectsMap.size(); }
	
	// To add a new key-value pair
	boolean add(String key, Object value)
	{
		if(this.objectsMap.containsKey(key)) return false;
		this.objectsMap.put(key, value);
		return true;
	}
	
	// To add a new key-value pair
	boolean add(Map<String, Object> map)
	{
		this.objectsMap.putAll(map);
		return true;
	}
	
	// If the key already exist the value of the key will be updated with the new value and return true
	// If the key doesn't exist in the object a new key-value pair would be created and return false
	boolean updateOrInsert(String key, Object value)
	{
		if(this.objectsMap.containsKey(key)) {
			this.objectsMap.replace(key, value);
			return true;
		}
		this.objectsMap.put(key, value);
		return false;
	}
	
	// Set a map as a JSON object (Will remove all existing key-value pair in the json object)
	boolean set(Map<String, Object> map) {
		this.objectsMap.putAll(map);
		return true;
	}
	
	// To fetch a value for a key exist in this JSON object otherwise returns null
	Object getValue(String key) {
		if(this.objectsMap.containsKey(key)) return objectsMap.get(key);
		return null;
	}
	
	// TO print all the key-value pair of the JSON Object
	@Override
	public String toString() {
		StringBuilder tempString = new StringBuilder();
		tempString.append(this.START);
		
		// Iterating through all the key-value pair of the JSON Object
		for(String key:objectsMap.keySet()) {
			tempString.append(this.QUOTE).append(key).append(this.QUOTE); // Appending the key with ""
			tempString.append(this.COLON); // Appending the colon sign after the key
			// Check if the value is also a string, then "" will be added 
			if(objectsMap.get(key).getClass().getSimpleName().equals("String")) {
				tempString.append(this.QUOTE).append(objectsMap.get(key)).append(this.QUOTE);
			}
			else tempString.append(objectsMap.get(key)); // If the value is not a string, appending it directly after the :
			
			tempString.append(this.COMMA); // Appending ',' after every key-value pair
		}
		tempString.deleteCharAt(tempString.length()-1); // Removing the last ',' before 
		tempString.append(this.END);
		return tempString.toString();
	}
	
	// To copy all key-value pair from one JSON object to another JSON Object
	public JSONTwo copy() {
		JSONTwo json = new JSONTwo(this.objectsMap);
		return json;
	}
	
	// Method to print JSON Object with indentation
	void pretty() {
		this.pretty(0); // Calling internal pretty method with level parameter, initial value of level is 0
	}
	
	// Method that will be internally called with level for indentation (initially the level is 0)
	private void pretty(int level) {
		int elementCount = this.size(); // Keeping track of the number of the elements in the map for omitting the last ','
		int currentIteration = 0; // For keeping track of the iteration number inside the loop
		System.out.println(String.join("", Collections.nCopies(level, "\t"))+this.START); // Adding Tab(multiplied by level number) before printing the starting '{' 
		for(String key:this.objectsMap.keySet()) {
			currentIteration++; // Updating iteration number
			System.out.print(String.join("", Collections.nCopies(level+1, "\t"))); // Adding tab(s) before printing the key-value pair
			System.out.print(this.QUOTE+key+this.QUOTE+this.COLON);
			
			// Checking if the value is another JSONTwo Object, then the pretty() method would be called with level parameter's value increased by 1 
			if(objectsMap.get(key).getClass().getSimpleName().equals("JSONTwo"))
			{
				System.out.println();
				((JSONTwo) objectsMap.get(key)).pretty(level+1);
				
			}
			// If the value is a string then appending "" with the value
			else if(objectsMap.get(key).getClass().getSimpleName().equals("String")) System.out.print(this.QUOTE+objectsMap.get(key)+this.QUOTE);
			else System.out.print(objectsMap.get(key));
			if(currentIteration != elementCount) System.out.println(this.COMMA); // Printing ',' after each key-value pair except for the last pair
			else System.out.println("");
		}
		System.out.print(String.join("", Collections.nCopies(level, "\t"))+this.END); // Adding Tab(multiplied by level number) before printing the ending '}'
	}
	
}
