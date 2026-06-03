package com.cx.fn.interview.ex24;

import java.util.List;
import java.util.stream.Collectors;

import com.cx.vo.Pair;


public class ExMain024 {
	
	
	public static void main(String[] args) {
		try {
			var pairs = List.of(Pair.of(1, 2), 
								Pair.of(1, 3), 
								Pair.of(2, 4));

			var map = pairs.stream().collect(Collectors.toMap(	Pair::getKey, 
																Pair::getValue, 
																ExMain024::replaceOld // <--- functon replaces values
											));

			map.forEach((k, v) -> System.out.println(k + " : " + v));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * This function is used to resolve the conflict of duplicate keys
	 * The 	first entry is 1, 2
	 * 	   	next entry is 1, 3 
	 * 		value 2 is replaced by 3
	 * 
	 * So now the map contains 1, 3 as latest value
	 * and collision of key 1 is avoided	
	 */
	private static Integer replaceOld(Integer oldVal, Integer newVal){		
		return newVal;
	}


}
