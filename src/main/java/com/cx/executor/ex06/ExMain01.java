package com.cx.executor.ex06;

public class ExMain01 {
	
	public static void main(String[] args) {
		try {
			CountHolder holder = new CountHolder(10);
			MyRunnable runnable = new MyRunnable(holder);
			Thread king = new Thread(runnable, "EVEN_THREAD");
			Thread queen = new Thread(runnable, "ODD_THREAD");
			
			queen.start();
			king.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
