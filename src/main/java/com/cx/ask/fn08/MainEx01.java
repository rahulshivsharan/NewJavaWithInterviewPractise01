package com.cx.ask.fn08;

import java.util.function.Function;

public class MainEx01 {

	public static void main(String[] args) {
		Function<Integer, Integer> fact = CalculateFactorial::factorial;
		System.out.println("Factorial of number 5 is "+fact.apply(5));
	}

}
