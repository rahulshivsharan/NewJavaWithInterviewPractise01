package com.cx.fn.filter.ex11;

import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Summation {
	
	
	public static int getSummationOf(int num) {
		
		UnaryOperator<Integer> incrementFunc = (n) -> n + 1;
		
		ToIntFunction<Integer> fn = (val) -> val;
		
		return Stream.iterate(1, incrementFunc)
				.limit(5)
				.mapToInt(fn)
				.sum();
	}
}
