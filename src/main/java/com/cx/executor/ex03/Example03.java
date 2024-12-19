package com.cx.executor.ex03;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Demonstration of resolving list of futures returning number.
 * getting the numbers and summing it up
 */
public class Example03 {

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newCachedThreadPool();
			List<Callable<Integer>> listOfCallable = Arrays.asList(
						() -> 1,
						() -> 2,
						() -> 3
					);
			List<Future<Integer>> futureList = service.invokeAll(listOfCallable);
			
			int sum = futureList.stream().map(f -> {
						try {
							return f.get();
						}catch(Exception e) {
							throw new IllegalStateException(e);
						}
					}).mapToInt(Integer::intValue).sum();
			
			System.out.println(sum);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			service.shutdown();
		}
	}

}
