package com.cx.ask.fn03;

import java.util.function.Consumer;
import java.util.function.Function;

public class MainEx02 {

	/**
	 * This calculates factorial recursively
	 * @param num
	 * @return
	 */
	private static Integer calculateFactorial (Integer num) {
		return (num >= 1) ? num * calculateFactorial(--num) : 1;
	}
	
	/**
	 * Method calls the factorial function and
	 * prints the output
	 * @param num
	 * @param factorial
	 * @param printFn
	 */
	private static void printFunction(Integer num, Function<Integer, Integer> factorial, Consumer<String> printFn) {
		Integer result = factorial.apply(num);
		
		StringBuffer strb = new StringBuffer();
		strb.append("The factorial of number ")
			.append("\"").append(num).append("\"")
			.append(" is ")
			.append("\"").append(result).append("\"");
		
		printFn.accept(strb.toString());
	}
	
	public static void main(String[] args) {
		Function<Integer, Integer> factorialFunction = MainEx02::calculateFactorial;		
		printFunction(5, factorialFunction, System.out::println);
	}

}
