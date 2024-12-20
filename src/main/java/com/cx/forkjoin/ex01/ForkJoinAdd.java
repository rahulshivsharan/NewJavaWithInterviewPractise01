package com.cx.forkjoin.ex01;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * Trying Fork-Join , here demonstrated RecursiveTask.
 * RecursiveTask returns result. RescursiveTask's compute method has a return type.
 * Here me demonstrate Summation of a number. For example for number 5 it will be 5 + 4 + 3 + 2 + 1 = 15  
 */
public class ForkJoinAdd extends RecursiveTask<Long>{
	private final long [] numbers;
	private final int start;
	private final int end;
	private static final long THRESHOLD = 10l;
	
	public ForkJoinAdd(long [] numbers) {
		this(numbers, 0, numbers.length);
	}
	
	private ForkJoinAdd(long [] numbers, int start, int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		
		int length = this.end - this.start;
		
		if(length <= THRESHOLD) {
			return this.add();
		}
		
		ForkJoinAdd firstTask = new ForkJoinAdd(numbers, this.start, length/2);
		firstTask.fork(); // start asynchronously
				
		ForkJoinAdd secondTask = new ForkJoinAdd(numbers, (this.start + length/2), this.end);
		
		Long secondTaskResult = secondTask.compute();
		Long firstTaskResult = firstTask.join();
		
		return secondTaskResult + firstTaskResult;
	}
	
	private long add() {
		long result = 0;
		
		for(int index = this.start; index < this.end; index++) {
			result += this.numbers[index];
		}
		
		return result;
	}
	
	public static long startForkJoinSum(long num) {
		long [] numbers = LongStream.rangeClosed(1, num).toArray();
		ForkJoinTask<Long>  task = new ForkJoinAdd(numbers);
		ForkJoinPool pool = new ForkJoinPool();
		long result = pool.invoke(task);
		return result;
	}
}
