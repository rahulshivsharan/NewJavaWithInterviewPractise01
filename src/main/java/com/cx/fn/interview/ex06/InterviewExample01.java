package com.cx.fn.interview.ex06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
	
	/**
	 * To count the number of times the numbers occurring 
	 * and return a key value pair where key is number and value is number of
	 * times it occurred
	 * @throws Exception
	 */
	private static void getNumberGroupSet01() throws Exception{
		List<Integer> numList = Arrays.asList(23, 45, 23, 66, 88, 66, 35);
		
		numList.stream().collect(Collectors.groupingBy((num) -> num, Collectors.counting())).entrySet().forEach((entryObject) -> {			
			System.out.println("Number "+entryObject.getKey()+", occuring "+entryObject.getValue());
		});
	}	
	
	
	
	/**
	 * To count the number of times the numbers occurring in number list
	 * and return a key value pair sorted by value in descending order
	 * 
	 * times it occurred
	 * @throws Exception
	 */
	private static void getNumberGroupSet03() throws Exception{
		List<Integer> numList = Arrays.asList(23, 45, 23, 66, 88, 66, 35, 23);
		
		Function<Integer, Integer> fn = new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer num) {				
				return num;
			}
		};
		
		Comparator<Map.Entry<Integer, Long>> comparatorFn = new Comparator<Map.Entry<Integer,Long>>() {
			
			@Override
			public int compare(Entry<Integer, Long> entry1, Entry<Integer, Long> entry2) {				
				return entry2.getValue().compareTo(entry1.getValue());
			}
		};
		
		Set<Map.Entry<Integer, Long>> setOfNumbers = numList.stream()
														.collect(Collectors.groupingBy(fn, Collectors.counting()))
														.entrySet().stream().sorted(comparatorFn).collect(Collectors.toCollection(LinkedHashSet::new));
		
		setOfNumbers.forEach((entryObject) -> {
			System.out.println("Number "+entryObject.getKey()+", occuring "+entryObject.getValue());
		});
	}
	
	
	public static void main(String[] args) {
		try {
			//getNumberOccuranceCount01();
			//getNumberOccuranceCount02();
			//getNumberOccuranceCount03();
			//getNumberOccuranceCount04();
			//getNumberGroupSet01();
			getNumberGroupSet03();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
