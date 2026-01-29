package com.cx.fn.interview.ex07;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InterviewExamples01 {
	
	private static boolean evenNum(Integer num) {
		return (num.intValue() % 2) == 0;
	}

	/*
	 * To filter even numbers from arrays of numbers
	 * Input array 11, 13, 16, 19, 22, 25, 27, 28, 43, 47, 49, 52, 56, 57, 61, 68, 76
	 * Output array [16, 22, 28, 52, 56, 68, 76] 
	 */
	private static void getEvenNumbers() throws Exception{
		List<Integer> numList = Arrays.asList(11, 13, 16, 19, 22, 25, 27, 28, 43, 47, 49, 52, 56, 57, 61, 68, 76);
		List<Integer> filteredList = numList.stream().filter(InterviewExamples01::evenNum).collect(Collectors.toList());
		System.out.println(filteredList);
	}
	
	/**
	 * Seperate odd and even numbers using lambda expression
	 * @throws Exception
	 */
	private static void seperateOddEvenNums() throws Exception{		
		List<Integer> numList = Arrays.asList(11, 13, 16, 19, 22, 25, 27, 28, 43, 47, 49, 52, 56, 57, 61, 68, 76);
		Map<Boolean, List<Integer>> map = numList.stream()
													.collect(Collectors.partitioningBy(InterviewExamples01::evenNum));
		
		System.out.println("Even Numbers "+map.get(true));
		System.out.println("Odd Numbers "+map.get(false));
	}
	
	public static void main(String[] args) {
		try {
			//getEvenNumbers();
			seperateOddEvenNums();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
