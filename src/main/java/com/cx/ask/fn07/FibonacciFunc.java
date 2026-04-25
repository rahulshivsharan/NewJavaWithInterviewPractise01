package com.cx.ask.fn07;

import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class FibonacciFunc {
	
	public static int getSum(int num) {
		
		UnaryOperator<int[]> fiboFunc = (numArray) -> {
			return new int[] { 
					numArray[1], 
					numArray[0] + numArray[1]
			};
		};
		
		ToIntFunction<int[]> func = (numArray) -> {
			return numArray[0];
		};
		
		return Stream.iterate(new int[]{0, 1} , fiboFunc) // [0, 1], [1, 1], [1, 2], [2, 3] [3, 5] [5, 8]....
					 .limit(num)
					 .mapToInt(func) // -> 0, 1, 1, 2, 3, 5
					 .sum();	// -> 0 + 1 + 1 + 2 + 3 + 5	 
	}
}
