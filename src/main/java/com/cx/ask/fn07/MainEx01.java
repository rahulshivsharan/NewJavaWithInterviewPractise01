package com.cx.ask.fn07;

import java.util.function.Function;

public class MainEx01 {

	public static void main(String[] args) {
		Function<Integer, Integer> fibonacciFunction = FibonacciFunc::getSum;
		int num = 6;
		System.out.println("FibonacciSum("+num+") = "+fibonacciFunction.apply(num));
	}

}
