package com.cx.fn.interview.ex06;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewExample01 {

	/**
	 * To count the number of times the numbers occurring 
	 * and return a key value pair where key is number and value is number of
	 * times it occurred
	 * @throws Exception
	 */
	private static void getNumberOccuranceCount01() throws Exception{
		List<Integer> numList = Arrays.asList(23, 45, 23, 66, 88, 66, 35);
		
		Map<Integer, Long> numMap =  numList.stream().collect(Collectors.groupingBy((num) -> {
			return num;
		}, Collectors.counting()));
		
		numMap.forEach((key, value) -> {
			System.out.println("Number "+key+" occurred "+value+" times");
		});
	}
	
	/**
	 * To count the number of times the numbers occurring 
	 * and return a key value pair where key is number and value is number of
	 * times it occurred
	 * @throws Exception
	 */
	private static void getNumberOccuranceCount02() throws Exception{
		List<Integer> numList = Arrays.asList(23, 45, 23, 66, 88, 66, 35);
		
		Function<Integer, Integer> fn = new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer num) {				
				return num;
			}
		};
		
		Map<Integer, Long> numMap =  numList.stream().collect(Collectors.groupingBy(fn, Collectors.counting()));
		
		numMap.forEach((key, value) -> {
			System.out.println("Number "+key+" occurred "+value+" times");
		});
	}
	
	
	/**
	 * To count the number of times the numbers occurring 
	 * and return a key value pair where key is number and value is number of
	 * times it occurred and return the key value in asceding sorted order by 
	 * number of occurances
	 * @throws Exception
	 */
	private static void getNumberOccuranceCount03() throws Exception{
		List<Integer> numList = Arrays.asList(23, 45, 23, 66, 88, 66, 35);
		
		Function<Integer, Integer> fn = new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer num) {				
				return num;
			}
		};
		
		Map<Integer, Long> numMap =  numList.stream().collect(Collectors.groupingBy(fn, Collectors.counting()))
											.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue())
											.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (val1, val2) -> {
												return val1;
											}, LinkedHashMap::new));
		
		
		numMap.forEach((key, value) -> {
			System.out.println("Number "+key+" occurred "+value+" times");
		});
	}
	
	
	/**
	 * To count the number of times the numbers occurring 
	 * and return a key value pair where key is number and value is number of
	 * times it occurred and return the key value in descending sorted order by 
	 * number of occurances
	 * @throws Exception
	 */
	private static void getNumberOccuranceCount04() throws Exception{
		List<Integer> numList = Arrays.asList(23, 45, 23, 66, 88, 66, 35);
		
		Function<Integer, Integer> fn = new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer num) {				
				return num;
			}
		};
		
		Map<Integer, Long> numMap =  numList.stream().collect(Collectors.groupingBy(fn, Collectors.counting()))
											.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
											.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)->{												
												return e1;
											}, LinkedHashMap::new));
		
		
		numMap.forEach((key, value) -> {
			System.out.println("Number "+key+" occurred "+value+" times");
		});
	}
	
	public static void main(String[] args) {
		try {
			//getNumberOccuranceCount01();
			//getNumberOccuranceCount02();
			//getNumberOccuranceCount03();
			getNumberOccuranceCount04();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
