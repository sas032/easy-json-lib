package com.json.lib.main;

public class JSON {
	
	final private String COMMA = ",";
	final private String START = "{";
	final private String END = "}";
	final private String COLON = ":";
	String stringValueToConvert = "";
	int intValueToConvert = 0;
	
	//Constructor
	JSON() {
		
	}
	
	JSON(String stringValueToConvert) {
		this.stringValueToConvert = stringValueToConvert;
	}
	
	JSON(int intValueToConvert) {
		this.intValueToConvert = intValueToConvert;
	}
	
	public JSON test() {
		JSON obj = new JSON();
		return obj;
		
	}

	//Create Key Value Pair
	public String set(String key, String value) {
		String returnJsonFinalString = stringValueToConvert;
		StringBuilder returnJsonString = new StringBuilder();
		
		String key_to_append ="\""+ key+"\"";
		String value_to_append = "\""+ value+"\"";
		if(stringValueToConvert=="") {
			returnJsonString = returnJsonString.append
					(START).append
					(key_to_append).append
					(COLON).append
					(value_to_append).append
					(END);
			returnJsonFinalString = returnJsonString.toString();
		}
		else {
			stringValueToConvert = stringValueToConvert.replace(END, "");
			returnJsonString = returnJsonString.append
					(stringValueToConvert).append
					(COMMA).append
					(key_to_append).append
					(COLON).append
					(value_to_append).append
					(END);
			returnJsonFinalString = returnJsonString.toString();
		}
		getString("testkey",returnJsonFinalString);
		System.out.println(returnJsonFinalString);
		return returnJsonFinalString;
	}
	
	public String value(JSON json) {
		String jsonString = "";
		jsonString = stringValueToConvert;
		return jsonString;
	}
	
	//Find a key to value pair for String
	public String getString(String key, String json) {
		String valueOfKey = "";
		final String keyStart = "{\"";
		final String keyEnd = "\":";
		String valueStart = "\":\"";
		final String valueEnd = "\"}";
		String foundKey = json.substring(json.indexOf(keyStart)+keyStart.length());
		foundKey = foundKey.substring(0,json.indexOf(keyEnd));
		foundKey = foundKey.replace(keyEnd, "");
		if(foundKey.equals(key)) {
			valueStart = key + valueStart;
			int indexOfValueStart = json.indexOf(valueStart);
			int indexOfValueEnd = json.indexOf(valueEnd);
			valueOfKey = json.substring(indexOfValueStart,indexOfValueEnd);
			valueOfKey = valueOfKey.replace(valueStart, "");
			
		}
		
		return valueOfKey;
	}
	
	//Find a key to value pair for int
	public int getInt(String key) {
		int valueOfKey = 0;
		
		return valueOfKey;
	}
	
	//Find if a key exists in the JSON
	public boolean existKey(String json) {
		boolean doExist = false;
		
		return doExist;
	}

}
