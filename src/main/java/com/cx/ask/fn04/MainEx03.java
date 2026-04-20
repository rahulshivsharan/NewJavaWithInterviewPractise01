package com.cx.ask.fn04;

import java.util.function.Function;

public class MainEx03 {
	
	public static TailCall<Long> factorial (int n, long accumulator){
		if(n < 1) {
			return TailCalls.done(accumulator);
		}
		
		TailCall<Long> fn = () -> {
			System.out.println("accumulator "+accumulator+", number "+n);
			return MainEx03.factorial(n - 1, n * accumulator);
		}; 
		
		return TailCalls.call(fn);
	}
	
	public static void main(String[] args) {
		long accumulator = 1L;
		int num = 5;
		System.out.println(MainEx03.factorial(num, accumulator).invoke());
	}

}
