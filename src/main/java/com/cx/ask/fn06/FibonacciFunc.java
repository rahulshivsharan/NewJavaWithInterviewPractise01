package com.cx.ask.fn06;

public class FibonacciFunc {
	
	public static Integer fibo(int n, int num1, int num2) {
		if (n == 0) return 0;
		return num1 + fibo(--n, num2, num1 + num2);
	}
}
