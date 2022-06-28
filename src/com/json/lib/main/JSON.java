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
		
		return returnJsonFinalString;
	}
	
	//Find a key to value pair for String
	public String getString(String key) {
		String valueOfKey = "";
		
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
