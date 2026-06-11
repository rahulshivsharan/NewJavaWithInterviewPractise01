package com.cx.fn.interview.ex34;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ExMain034 {

	public static void main(String[] args) {
		//doNormalPrimeFactors(56);
		functionalPrimeFactors(56);
	}

	/**
	 * Prime factors of a number using normal logic
	 * 56 = 2 x 2 x 2 x 7 
	 * @param num
	 */
	private static void doNormalPrimeFactors(int num) {
		List<Integer> factors = new ArrayList<Integer>();

		for (int i = 1; i <= num; i++) {

			if (i > 1 && (num % i) == 0) {
				factors.add(i);
				num = (num / i);
				i = 0;
			}

		}

		factors.add(num);
		if (num != 1) {
			factors.add(1);
		}

		factors.stream().forEach(System.out::println);
	}
	
	/**
	 * functional way of getting Prime factors 
	 * 56 = 2 x 2 x 2 x 7
	 * @param numberVal
	 */
	private static void functionalPrimeFactors(int numberVal) {
		List<Integer> factors = new ArrayList<Integer>();
		AtomicInteger num = new AtomicInteger(numberVal);  
		Stream.iterate(2, (n) -> {
			return n + 1; 
		}).takeWhile((i) -> {
			return num.get() > 1;
		}).forEach((i) -> {
			while((num.get() % i) == 0) {
				factors.add(i);
				int newNum = num.get() / i;
				num.set(newNum);
			}
		});
		
		factors.stream().forEach(System.out::println);
	}
}
