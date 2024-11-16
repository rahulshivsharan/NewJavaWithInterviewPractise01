package com.cx.fn.main;

import java.util.function.Function;

import com.cx.fn.IncrementByTwoFunction;

public class IncrementByTwoMain01 {
	public static void main(String [] args) {
		Function<Integer, Integer> increaseByTwo = new IncrementByTwoFunction();
		int output = increaseByTwo.andThen(increaseByTwo).andThen(increaseByTwo).apply(5);
		System.out.println(output);
	}
}
