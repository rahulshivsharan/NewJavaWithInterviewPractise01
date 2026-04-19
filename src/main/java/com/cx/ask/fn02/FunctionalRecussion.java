package com.cx.ask.fn02;

import java.util.function.Function;

public class FunctionalRecussion {
	
	public static Function<Integer, Integer> factorialFn = new Function<Integer, Integer>() {
		
		@Override
		public Integer apply(Integer num) {
			return (num >= 1) ? num * FunctionalRecussion.factorialFn.apply(--num) : 1;			
		}
	};

	
}
