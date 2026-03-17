package com.cx.fn.interview.ex19;

import java.util.Iterator;

public class ExampleEx01 {

	public static void main(String[] args) {
		try {
			MultiThreadHandle obj = new MultiThreadHandle();
			
			Thread[] threads = new Thread[]{
				new Thread(new RunnableTestOne(obj),"THD-1"),
				new Thread(new RunnableTestTwo(obj),"THD-2"),
				new Thread(new RunnableTestTwo(obj),"THD-3"),
				new Thread(new RunnableTestTwo(obj),"THD-4"),
				new Thread(new RunnableTestTwo(obj),"THD-5"),
				new Thread(new RunnableTestTwo(obj),"THD-6"),
				new Thread(new RunnableTestTwo(obj),"THD-7"),
				new Thread(new RunnableTestTwo(obj),"THD-8"),
				new Thread(new RunnableTestTwo(obj),"THD-9"),
				new Thread(new RunnableTestTwo(obj),"THD-10")
			};
			
			for(Thread t : threads) {
				t.start();
			}
			
		}catch(Exception e) {
			e.printStackTrace();			
		}
	}

}
