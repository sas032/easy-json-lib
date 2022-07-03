package com.json.lib.main;

import com.json.lib.main.*;

public class Test {

	public static void main(String[] args) {
		JSON jsonObj = new JSON();
		jsonObj.set("testkey","testval");
//		jsonObj.set("testkey2","testval2");
//		System.out.println(jsonObj);
		
		
//		for(Object str:jsonObj) {
//			
//		}
		
		JSONTwo jsonTwo = new JSONTwo();
		jsonTwo.add("abc", 1);
		jsonTwo.add("a", "dfsd");
		jsonTwo.add("b", 12.4);
		JSONTwo jsonThree = jsonTwo.copy();
		jsonTwo.add("c", jsonThree);
		
		System.out.println(jsonTwo);
		
		jsonTwo.updateOrInsert("a", "value for a");
		jsonTwo.updateOrInsert("d", "new");
		System.out.println(jsonTwo);
		
		JSONTwo jsonFour = jsonTwo.copy();
		jsonTwo.add("Big Obj",jsonFour);
		
		jsonTwo.pretty();
	}
}

