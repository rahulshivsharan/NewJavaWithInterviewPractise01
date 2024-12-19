package com.cx.executor.ex05;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


/**
 * Scheduled Executor service which runs after every fixed interval.
 * The below scheduled Executor service first delays its execution by 5 seconds, then it continues running after
 * every 1 second. 
 */
public class Example05 {

	private static int count = 0;
	private static final int INITIAL_5_SEC_DELAY = 5; // 5 seconds
	private static final int REPEAT_AFTER_1_SEC_INTERVAL = 1; // 1 second
	private static final int WAIT_FOR_1_SECOND = 1000; // 1 second
	
	public static void main(String[] args) {
		ScheduledExecutorService service = null;
		try {
			service = Executors.newScheduledThreadPool(1);
			
			Runnable task1 = () -> {
				count++;
				System.out.println("Runnning...task1 - count " + count);
			};
			
			ScheduledFuture<?> scheduledFuture = service.scheduleAtFixedRate(task1, INITIAL_5_SEC_DELAY, REPEAT_AFTER_1_SEC_INTERVAL, TimeUnit.SECONDS);
			
			while(true) {
				System.out.println("Count "+count);
				Thread.sleep(WAIT_FOR_1_SECOND);
				
				if(count == 5) {
					System.out.println("Count is 5, cancel the scheduledFuture !");
					scheduledFuture.cancel(true);
					service.shutdown();
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}

}
