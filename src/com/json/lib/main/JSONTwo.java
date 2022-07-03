package com.json.lib.main;

import java.util.Map;
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
		String returnString = "";
		StringBuilder tempString = new StringBuilder();
		tempString.append(this.START);
		for(String key:objectsMap.keySet()) {
			tempString.append(this.QUOTE).append(key).append(this.QUOTE);
			tempString.append(this.COLON);
			if(objectsMap.get(key).getClass().getSimpleName().equals("String")) {
				tempString.append(this.QUOTE).append(objectsMap.get(key)).append(this.QUOTE);
			}
			else tempString.append(objectsMap.get(key));
			
			tempString.append(this.COMMA);
		}
		tempString.deleteCharAt(tempString.length()-1);
		tempString.append(this.END);
		returnString = tempString.toString();
		return returnString;
	}
	
	// To copy all key-value pair from one JSON object to another JSON Object
	public JSONTwo copy() {
		JSONTwo json = new JSONTwo(this.objectsMap);
		return json;
	}
	
}
