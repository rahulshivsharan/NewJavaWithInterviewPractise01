package com.cx.executor.ex01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Examples of simple executor service examples
 */
public class Example01Main {

	private static void ex01() throws Exception{
		ExecutorService executor = Executors.newFixedThreadPool(4);
		
		Callable<String> callable = new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				StringBuffer strb = new StringBuffer();
				strb.append("Task executed by 1 : \"").append(Thread.currentThread().getName()).append("\"");
				return strb.toString();
			}
		};
		
		Future<String> f = executor.submit(callable);
		
		while (!f.isDone()) {
			System.out.println(f.get());			
		}
		
		executor.shutdown();
	}
	
	private static void ex02() throws Exception{
		ExecutorService executor = Executors.newFixedThreadPool(4);
				
		executor.submit(() -> {
			StringBuffer strb = new StringBuffer();
			strb.append("Task executed by 2 : \"").append(Thread.currentThread().getName()).append("\"");
			
			System.out.println(strb.toString());
		});
		
		
		executor.shutdown();
	}
	
	private static void ex03() throws Exception{
		ExecutorService executor = Executors.newFixedThreadPool(4);		
		
		Future<String> f = executor.submit(() -> {
			StringBuffer strb = new StringBuffer();
			strb.append("Task executed by 3 : \"").append(Thread.currentThread().getName()).append("\"");
			return strb.toString();
		});
		
		while (!f.isDone()) {
			System.out.println(f.get());			
		}
		
		executor.shutdown();
	}
	
	public static void main(String[] args) {
		try {			
			ex01();
			ex02();
			ex03();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
