package com.cx.ask.fn08;

import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class CalculateFactorial {
	
	public static int factorial(int num) {
		
		if(num < 0) new IllegalArgumentException("Number must be non-negative");
		if(num == 0) return 1;

		IntBinaryOperator fn = (num1, num2) -> {
			return num1 * num2;
		};
		
		return IntStream.rangeClosed(1, num).reduce(1, fn);
	}
}	
