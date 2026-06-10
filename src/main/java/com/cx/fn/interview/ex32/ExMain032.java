package com.cx.fn.interview.ex32;

import java.util.stream.Stream;

public class ExMain032 {

	public static void main(String[] args) {
		int val = multiply(12, 3);
		System.out.println(val);
	}
	
	/**
	 * Multiplying numbers without multiplication operator
	 * multiply(2,3) - 2 + 2 + 2
	 * @param a
	 * @param b
	 * @return
	 */
	private static Integer multiply(int a, int b) {
		Integer val = 	Stream.iterate(1, (i) -> {							 
							return i + 1;
						}).limit(b).map((i) -> {
							return a;
						}).reduce(0, (result, numberA) -> {							
							return result + numberA;
						});
		
		return val;
	}

}
