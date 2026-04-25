package com.cx.ask.fn05;

import java.util.function.Function;

public class MainEx01 {

	public static TailCall<Integer> fibonacciSum(int n, int num1, int num2, int totalSum) {
		if (n == 0) {
			return TailCalls.done(totalSum);
		}

		
		// Either use the below code
		// or the TailCall instanciation
		// with apply override
		/*
		TailCall<Integer> fn = () -> { 
			return MainEx01.fibonacciSum(n - 1, num2, num1 + num2, totalSum + num1);
		};*/
		

		
		TailCall<Integer> fn = new TailCall<Integer>() {

			@Override
			public TailCall<Integer> apply() {				
				TailCall<Integer> tailCall = MainEx01.fibonacciSum(	n - 1, 
																	num2, 
																	num1 + num2, 
																	totalSum + num1);
				return tailCall;
			}
		};

		return TailCalls.call(fn);
	}

	public static void main(String[] args) {
		int num = 6;
		int finalSum = 0;
		TailCall<Integer> tailCall = MainEx01.fibonacciSum(num, 0, 1, finalSum);		
		System.out.println("Fibonacci for number "+num+" is "+tailCall.invoke());
	}

}
