package com.cx.fn.interview.ex11;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * For in put of array if numbers 
 * give sum of all even numbers
 * give sum of all odd numbers
 * 
 * If input array is [1, 3, 4, 5, 8, 9, 10, 12, 15, 16]
 * Output is
 * Total of Even numbers[4, 8, 10, 12, 16] = 50
 * Total of Odd numbers [1, 3, 5, 9, 15] = 33	
 */
public class InterviewEx01 {

	
	private static void solution02() throws Exception {

		Predicate<Integer> evenNum = new Predicate<Integer>() {

			@Override
			public boolean test(Integer num) {
				return num % 2 == 0;
			}
		};
		
		Predicate<Integer> oddNum = new Predicate<Integer>() {

			@Override
			public boolean test(Integer num) {
				return num % 2 != 0;
			}
		};


		List<Integer> nums = Arrays.asList(1, 3, 4, 5, 8, 9, 10, 12, 15, 16);
		List<Integer>  evenNumbers = nums.stream().filter(evenNum).toList();
		List<Integer>  oddNumbers = nums.stream().filter(oddNum).toList();

		Map<Boolean, Integer> map = nums.stream().collect(Collectors.partitioningBy(evenNum, Collectors.summingInt(Integer::intValue)));
		
		Integer sumOfEvenNums = map.get(true);
		Integer sumOfOddNums = map.get(false);

		System.out.println("Total of Even numbers" + evenNumbers.toString() + " = " + sumOfEvenNums);
		System.out.println("Total of Odd numbers " + oddNumbers.toString() + " = " + sumOfOddNums);
	}
	
	
	private static void solution01() throws Exception {
		Predicate<Integer> evenNum = new Predicate<Integer>() {

			@Override
			public boolean test(Integer num) {
				return num % 2 == 0;
			}
		};

		BinaryOperator<Integer> sumFn = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer num1, Integer num2) {
				return num1 + num2;
			}
		};

		List<Integer> nums = Arrays.asList(1, 3, 4, 5, 8, 9, 10, 12, 15, 16);

		Map<Boolean, List<Integer>> map = nums.stream().collect(Collectors.partitioningBy(evenNum));
		
		Integer sumOfEvenNums = map.get(true).stream().reduce(0, sumFn);
		Integer sumOfOddNums = map.get(false).stream().reduce(0, sumFn);

		System.out.println("Total of Even numbers" + map.get(true).toString() + " = " + sumOfEvenNums);
		System.out.println("Total of Odd numbers " + map.get(false).toString() + " = " + sumOfOddNums);
	}
	
	public static void main(String[] args) {
		try {
			//solution01();
			solution02();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
