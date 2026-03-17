package com.cx.fn.interview.ex19;

public class RunnableTestTwo implements Runnable{
	
	private MultiThreadHandle handle; 
	
	public RunnableTestTwo(MultiThreadHandle handle) {
		this.handle = handle;
	}
	
	@Override
	public void run() {
		handle.test2();		
	}
}
