package com.cx.fn.interview.ex19;

public class RunnableTestOne implements Runnable{
	
	private MultiThreadHandle handle;
	
	public RunnableTestOne(MultiThreadHandle handle) {
		this.handle = handle;
	}

	@Override
	public void run() {
		handle.test1();		
	}
	
}
