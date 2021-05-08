package com.wallethub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapSortingByValue {

	public static void main(String[] args) {
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("abs", 2);
		hmap.put("abs1", 89);
		hmap.put("asfddf", 10);
		hmap.put("545", 8777);
		
		System.out.println("++++"+hmap);
		
		Set<Entry<String, Integer>> entrySet = hmap.entrySet();
		
		System.out.println("+++++++"+sortHashmap(hmap));
		String s = "asdfdfd";
		int[] array= {1 , 2 , 34 , 5};
		int length = array.length;
		s.length();
	}
	
	public static HashMap<String, Integer> sortHashmap(HashMap<String, Integer> hunmap) {
		
		List<Entry<String, Integer>> lst = new  ArrayList<Entry<String, Integer>>(hunmap.entrySet());
		
		Comparator<Entry<String, Integer>> comparator = new Comparator<Entry<String, Integer>>() {
			
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				// TODO Auto-generated method stub
				return e1.getValue().compareTo(e2.getValue());
			}
		};
		
		Collections.sort(lst,comparator);
		
		LinkedHashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		
		for (Entry<String, Integer> entry : lst) {
			temp.put(entry.getKey(), entry.getValue());
			
		}
		return temp;
		
	}

}
