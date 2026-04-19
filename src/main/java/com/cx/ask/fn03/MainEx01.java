package com.cx.ask.fn03;

import java.util.function.Function;

public class MainEx01 {

	/**
	 * This calculates factorial recursively
	 * @param num
	 * @return
	 */
	private static Integer calculateFactorial (Integer num) {
		return (num >= 1) ? num * calculateFactorial(--num) : 1;
	}
	
	public static void main(String[] args) {
		
		// Create a function
		Function<Integer, Integer> factorialFunction = MainEx01::calculateFactorial;
		
		// Call the function to give output for factorial of number
		System.out.println(factorialFunction.apply(5));
	}

}
