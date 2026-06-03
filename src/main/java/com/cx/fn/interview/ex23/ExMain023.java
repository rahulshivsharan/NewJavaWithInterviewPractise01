package com.cx.fn.interview.ex23;

import java.util.List;
import java.util.stream.Collectors;

import com.cx.vo.Pair;

public class ExMain023 {
	
	public static void main(String[] args) {
		var pairs = List.of(Pair.of(1, 2), 
							Pair.of(1, 3), 
							Pair.of(2, 4));
		
		/**
		 * Collectors.toMap creates Key value
		 * (1 -> 2)
		 * (1 -> 3) <--- Duplicate Key Occurred	 
		 * 
		 * Uses getKey() as the map key
		 * 		getValue() as the map value
		 * 
		 * Requires keys to be unique
		 */
		var map = pairs.stream().collect(Collectors.toMap(Pair::getKey, Pair::getValue));
		
		map.forEach((k, v) -> System.out.println(k + " : " + v));
	}
	

}
