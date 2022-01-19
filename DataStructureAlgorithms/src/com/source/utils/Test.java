package com.source.utils;

import java.util.HashMap;
import java.util.Iterator;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> cache = new HashMap<String, String>();
		cache.put("Twenty One","21");
		cache.put("Twenty Two","22");
		cache.put("Twenty Three","23");
		cache.put("Twenty Four","24");
		
		Iterator<String> keySetIterator = cache.keySet().iterator();

		while(keySetIterator.hasNext()){
			String key = keySetIterator.next();
		  System.out.println("key: " + key + " value: " + cache.get(key));
		}

	}

}
