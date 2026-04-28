package com.cx.fn.filter.ex12;

import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Operation {

	/**
	 * Mutiplication of numbers without using
	 * mutiplication operator
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int mutiply(int num1, int num2) {
		UnaryOperator<Integer> incrementFunc = (n) -> {
			return n + 1;
		};
		
		ToIntFunction<Integer> fn = (val) -> {
			return num2;
		};
		
		return Stream.iterate(1, incrementFunc)
					 .limit(num1)
					 .mapToInt(fn)
					 .sum();
	}
	
	/**
	 * Calculating square of numbers
	 * without using square operator
	 * @param num
	 * @return
	 */
	public static int squareOfNum(int num) {
		
		UnaryOperator<Integer> incrementFunc = (n) -> {
			return n + 1;
		};
		
		ToIntFunction<Integer> fn = (val) -> {
			return num;
		};
		
		return Stream.iterate(1, incrementFunc)
					 .limit(num)
					 .mapToInt(fn)
					 .sum();
	}
}
