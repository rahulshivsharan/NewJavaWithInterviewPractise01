package com.cx.fn.filter.ex01;

import java.util.function.Predicate;

public class EvenNumPredicate implements Predicate<Integer>{

	@Override
	public boolean test(Integer num) {		
		return (num%2 == 0);
	}
	
}
