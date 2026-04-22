package com.cx.ask.fn06;



public class MainEx01 {

	public static void main(String[] args) {
		
		TriFunction<Integer ,Integer, Integer, Integer> fibonacciFunction = FibonacciFunc::fibo; 
		
		System.out.println(FibonacciFunc.fibo(6, 0, 1));
	}

}
