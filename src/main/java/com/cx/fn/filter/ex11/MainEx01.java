package com.cx.fn.filter.ex11;

import java.util.function.Function;

public class MainEx01 {

	public static void main(String[] args) {
		try {
			Function<Integer, Integer> func = Summation::getSummationOf;			
			System.out.println(func.apply(5));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
