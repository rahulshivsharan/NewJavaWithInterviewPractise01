package com.cx.fn.interview.ex10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Find the third highest number
 * For input 23, 11, 45, 2, 54, 32, 29
 * third highest number is 32.
 */
public class InterviewExample01 {

	
	private static void practise02() throws Exception{
		List<Integer> numlist = Arrays.<Integer>asList(23, 11, 45, 2, 54, 32, 29);

		Integer num = numlist.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst().orElseThrow();
				

		System.out.println("Third highest number " + num);
	}
	
	private static void practise01() throws Exception{
		List<Integer> numlist = Arrays.<Integer>asList(23, 11, 45, 2, 54, 32, 29);

		List<Integer> sortedList = numlist.stream().sorted((num1, num2) -> num2.compareTo(num1))
				.collect(Collectors.toList());

		System.out.println("Third highest number " + sortedList.get(2));
	}
	
	public static void main(String[] args) {
		try {
			//practise01();
			practise02();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
