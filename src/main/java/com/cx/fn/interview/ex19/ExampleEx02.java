package com.cx.fn.interview.ex19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExampleEx02 {

	public static void main(String[] args) {
		try {
			MultiThreadHandle obj = new MultiThreadHandle();
			ExecutorService executor = Executors.newFixedThreadPool(10);
			RunnableTestOne run1 = new RunnableTestOne(obj);
			RunnableTestTwo run2 = new RunnableTestTwo(obj);
			
			executor.execute(run1);
			executor.execute(run2);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
