package com.cx.executor.ex06;

public class MyRunnable implements Runnable{
	
	public MyRunnable(CountHolder holder) {
		this.holder = holder;
	}

	private CountHolder holder;
	
	@Override
	public void run() {
		try {
			holder.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
