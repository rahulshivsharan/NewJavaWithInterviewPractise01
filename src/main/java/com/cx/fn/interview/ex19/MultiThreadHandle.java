package com.cx.fn.interview.ex19;

public class MultiThreadHandle {
	public static int val = 5;
	
	public synchronized void test1() {
		val++;
		
		System.out.println(Thread.currentThread().getName()+" Inside Test1 method "+val);
		
		while(true) {
			try {
				Thread.sleep(Long.MAX_VALUE);
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static synchronized void test2() {
		val++;
		
		System.out.println(Thread.currentThread().getName()+" Inside Test2 method "+val);
		
		while(true) {
			try {
				Thread.sleep(Long.MAX_VALUE);
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}
