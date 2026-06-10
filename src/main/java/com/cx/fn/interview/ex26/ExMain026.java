package com.cx.fn.interview.ex26;

import java.util.List;

/**
 * Performance model of stream pipeline
 * The order of intermediate operation like map and filter matters for performance
 * It depends on 
 * how many elements run downstream
 * how many expensive operations run
 */
public class ExMain026 {	
	
	public static void main(String[] args) {
		//first();
		second();
	}
	
	
	/*
	 *	here intermediate function 'map' and then 'filter' are lazily called 
	 *	after the terminal function 'findFirst' function. 
	 *	 
	 *	iterates to 1, prints 'map 1' returns (1 * 2 = 2) and prints 'filter 2' returns (2 > 4) false. stops
	 *	iterates to 2, prints 'map 2' returns (2 * 2 = 4) and prints 'filter 4' returns (4 > 4) false. stops
	 *	iterates to 3, prints 'map 3' returns (3 * 2 = 6) and prints 'filter 6' returns (6 > 4) true. 
	 *	calls the terminal function 'findFirst' which is returning previous result as 6 and exits
	 */
	private static void first() {
		var num = List.of(1, 2, 3, 4).stream().map((x) -> {
			System.out.println("map: " + x);
			return (x * 2);
		}).filter((n) -> {
			System.out.println("filter: " + n);
			return n > 4;
		}).findFirst().get();

		System.out.println(num);
	}
	
	/*
	 *	here intermediate function 'filter' and then 'map' are lazily called 
	 *	after the terminal function 'findFirst' function. 
	 *	 
	 *	iterates to 1, prints 'filter 1' returns (1 * 2 > 4) false 
	 *	iterates to 2, prints 'filter 2' returns (2 * 2 > 4) false
	 *	iterates to 3, prints 'filter 3' returns (3 * 2 > 4) and prints 'map 3' returns (3 * 2 = 6)  
	 *	calls the terminal function 'findFirst' which is returning previous result as 6 and exits
	 */
	private static void second() {
		var num = List.of(1, 2, 3, 4).stream().filter((n) -> {
			System.out.println("filter: " + n);
			return (n * 2) > 4;
		}).map((x) -> {
			System.out.println("map: " + x);
			return (x * 2);
		}).findFirst().get();

		System.out.println(num);
	}
	


}
