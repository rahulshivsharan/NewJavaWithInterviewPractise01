package com.cx.fn.interview.ex01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class InterviewMainEx01 {
	
	/**
	 * This methods shows how to find numbers occuring more than once and
	 * return the numbers in set. 
	 * @throws Exception
	 */
	private static void implementationOne() throws Exception{
		final List<Integer> numList = Arrays.asList(12, 56, 12, 77, 56, 32, 98, 44, 33, 77);
		
		Set<Integer> nums = numList.stream()
									.filter((num) -> {
										return Collections.frequency(numList, num) > 1;
									}).collect(Collectors.toSet());
		
		System.out.println(nums);
	}
	
	/**
	 * This methods shows how to find numbers occuring more than once and
	 * return the numbers in set. 
	 * @throws Exception
	 */
	private static void implementationTwo() throws Exception {
		List<Integer> numList = Arrays.asList(12, 56, 12, 77, 56, 32, 98, 44, 33, 77);
		
		Set<Integer> nums  = numList.stream()
									.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // applying groupby to interger with count
									.entrySet() 
									.stream()
									.filter((entry) -> entry.getValue() > 1)
									.map((entry) -> entry.getKey())
									.collect(Collectors.toSet());
		
		System.out.println(nums);
	}

	public static void main(String[] args) {
		try {
			implementationOne();
			implementationTwo();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
