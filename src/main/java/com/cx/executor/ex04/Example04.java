package com.cx.executor.ex04;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * Schedule a task to run after 5 seconds
 */
public class Example04 {

	public static void main(String[] args) {
		ScheduledExecutorService service = null;
		try {
			service = Executors.newScheduledThreadPool(1);
			
			// Creating runnable task
			Runnable task2 = () -> System.out.println("Running Task 2");
			
			// Task 1 runs
			task("Task 1");
			
			// Schedule the task2 to run after 5 seconds delay
			service.schedule(task2, 5, TimeUnit.SECONDS);
			
			// run task 3
			task("Task 3");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			service.shutdown();
		}
	}

	private static void task(String taskName) {
		System.out.println("Running "+taskName);
	}
}
