package com.cx.executor.ex06;

public class CountHolder {
	private volatile int count;
	private int maxCount;
	
	public CountHolder(int maxCount) {
		this.count = 0;
		this.maxCount = maxCount;
	}

	public synchronized int getCount() {
		return count;
	}

	public synchronized void setCount(int count) {		
		this.count = count;
	}
	
	public synchronized void execute() throws Exception{
		while(true) {
			
			// keep of looping until count is more than max value
			// if count greater then max value, then release lock and 
			// throw 'Interrupt exception' 
			if(this.getCount() > this.maxCount) {	
				this.notifyAll();
				throw new InterruptedException("Count maxed out");
			}
			
			Thread.sleep(1000);
			boolean isEvenThread = "EVEN_THREAD".equals(Thread.currentThread().getName()) ? true : false;
			boolean isCountEvenNumber = (this.getCount()%2 == 0) ? true : false;
			
			// if thread 'even_thread' is running and the count is odd number
			// then wait and release the lock
			if(isEvenThread == true && isCountEvenNumber == false) {				
				this.wait();
			}
			
			// if thread 'odd_thread' is running and the count is even number
			// then wait and release the lock
			if(isEvenThread == false && isCountEvenNumber == true) {
				this.wait();
			}
			
			
			System.out.println(Thread.currentThread().getName()+" printing "+this.getCount());
			
			this.setCount(++count);		
			this.notifyAll();
		} // keep on looping
		
	}
}
