package com.Mavericks;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MapConc {

	public static void main(String[] args) {
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("Name", "acc");
		hmap.put("A", "123");
		hmap.put("B", "256");
		hmap.put("C", "25");
		hmap.put("D", "555");
		
		System.out.println("The hashmap is +"+hmap);
		
		Set<Entry<String, String>> entrySet = hmap.entrySet();
		
		for (Entry<String, String> entry : entrySet) {
			System.out.println("The key value is :"+entry.getKey()+ " The value is :"+entry.getValue());
		}

	}

}
