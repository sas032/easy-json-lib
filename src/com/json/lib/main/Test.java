package com.json.lib.main;

import com.json.lib.main.*;

public class Test {

	public static void main(String[] args) {
		JSON jsonObj = new JSON();
		jsonObj.set("testkey","testval");
//		for(String str:jsonObj) {
//			
//		}
		System.out.println(jsonObj.getClass().getSimpleName());
	}

}
