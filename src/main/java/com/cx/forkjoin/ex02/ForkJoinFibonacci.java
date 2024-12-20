package com.cx.forkjoin.ex02;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * This below code is demonstration of fork-join RecursiveAction.
 * The RecursiveAction is used when we need to do some operation and here 
 * there is no return type of 'compute' method.
 * So below example is to calculate fibonacci number.
 * 
 * fibonacci of 5 which is 
 * 
 *   f(5) = f(4) + f(3)
 *          f(3) + f(2) + f(2) + f(1)
 *          f(2) + f(1) + f(1) + f(0) + f(1) + f(0) + f(1) 
 */
public class ForkJoinFibonacci extends RecursiveAction{
	
	private volatile long number;
	private static final long THRESHOLD = 10;
	
	public ForkJoinFibonacci(long number) {
		this.number = number;
	}
	
	public long getNumber() {
		return number;
	}
	
	@Override
	protected void compute() {
		long n = number;
		
		if(n <= THRESHOLD) {
			number = fib(n);
		}else {
			ForkJoinFibonacci f1 = new ForkJoinFibonacci(n - 1);
			ForkJoinFibonacci f2 = new ForkJoinFibonacci(n - 2);
			ForkJoinTask.invokeAll(f1, f2);
			number = f1.getNumber() + f2.getNumber();
		}
	}

	private static long fib(long n) {
		if(n <= 1) {
			return n;
		}else {
			return fib(n -2) + fib(n - 1);
		}
	}

	
}
