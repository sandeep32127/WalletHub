package com.wallethub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class CheckHashMap {

	public static void main(String[] args) {
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("abc", "123");
		hmap.put("abdc", "12d3");
		hmap.put("sd", "dfff");
		hmap.put("sddf", "dfdfdfff");
		
		
		for (Entry<String, String> entryset : hmap.entrySet()) {
			System.out.println(entryset.getKey()+ "222222222" + entryset.getValue());
		}
		
		Iterator<Entry<String, String>> iterator = hmap.entrySet().iterator();
		
		while(iterator.hasNext()) {
			Entry<String, String> next = iterator.next();
			System.out.println(next.getKey());
		}
	}

}
