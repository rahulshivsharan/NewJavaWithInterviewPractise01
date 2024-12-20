package com.cx.forkjoin.ex02;

import java.util.concurrent.ForkJoinPool;

public class ExampleFiboMain02 {

	public static void main(String[] args) {
		try {
			ForkJoinFibonacci fibo = new ForkJoinFibonacci(6);
			ForkJoinPool pool = new ForkJoinPool();
			pool.invoke(fibo);
			long result = fibo.getNumber();
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
