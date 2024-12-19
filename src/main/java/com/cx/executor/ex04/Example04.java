package com.cx.executor.ex04;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


/**
 * Demonstration of scheduler executor services
 */
public class Example04 {
	
	/**
	 * Schedule a runnable task to run after 5 seconds
	 */
	private static void scheduleRunnableTask() throws Exception{
		ScheduledExecutorService service = null;
		try {
			service = Executors.newScheduledThreadPool(1);
			
			// Creating runnable task
			Runnable task2 = () -> System.out.println("In Runnable Task 2");
			
			// Task 1 runs
			task("Task 1");
			
			// Schedule the task2 to run after 5 seconds delay
			service.schedule(task2, 5, TimeUnit.SECONDS);
			
			// run task 3
			task("Task 3");
			
			
		}catch(Exception e) {
			throw new Exception("Exception occured while running scheduled runnable task ", e);
		}finally {
			System.out.println("Shutdown Scheduled Runnable Task");
			service.shutdown();
		}
	}
	
	private static void scheduleCallableTask() throws Exception{
		ScheduledExecutorService service = null;
		try {
			service = Executors.newScheduledThreadPool(1);
			
			// Creating callable task
			Callable<String> task2 = () -> {
				System.out.println("I am Callable Task");
				return "Task 2";
			};
			 
			
			// Task 1 runs
			task("Task 1");
			
			// Schedule the task2 to run after 5 seconds delay
			ScheduledFuture<String> futureTask = service.schedule(task2, 5, TimeUnit.SECONDS);
			
			// run task 3
			task("Task 3");
			
			System.out.println(futureTask.get());
			
		}catch(Exception e) {
			throw new Exception("Exception occured while running scheduled runnable task ", e);
		}finally {
			System.out.println("Shutdown Scheduled Callable Task");
			service.shutdown();
		}
	}
	
	private static void task(String taskName) {
		System.out.println("Running "+taskName);
	}

	public static void main(String[] args) {
		try {
			scheduleRunnableTask();
			System.out.println("\n\n -------------- \n\n");
			scheduleCallableTask();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
