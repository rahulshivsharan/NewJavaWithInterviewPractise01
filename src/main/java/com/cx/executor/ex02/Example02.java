package com.cx.executor.ex02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example02 {
	
	private static void otherTask(String taskDescription) {
		System.out.println(taskDescription);
	}

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(5);
			
			// Runnable, return void, nothing, submit and run the task
			service.submit(() -> System.out.println("I am Runnable Task"));
			
			// Callable, return a future, submit and run the task async
			Future<Integer> futureTask = service.submit(() ->{
				Thread.sleep(5000);
				System.out.println("I am Callable Task");
				return 1 + 1;
			});
			
			Example02.otherTask("Before Future Result");

			// block untill the future return the result, 
			Integer result = futureTask.get();
			
			System.out.println("Get Future result "+result);
			
			Example02.otherTask("After Future Result");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			service.shutdown();
		}
	}

}
