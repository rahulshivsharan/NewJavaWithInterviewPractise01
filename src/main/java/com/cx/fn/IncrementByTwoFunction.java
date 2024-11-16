package com.cx.fn;

import java.util.function.Function;

public class IncrementByTwoFunction implements Function<Integer, Integer>{

	@Override
	public Integer apply(Integer num) {		
		return (2 + num);
	}
	
}
