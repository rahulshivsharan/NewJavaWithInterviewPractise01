package com.cx.fn.interview.ex04;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewEx03 {
	
	private static void giveNumberOccuranceEx01() throws Exception{
		List<Integer> list = Arrays.<Integer>asList(11, 45, 67, 11, 44, 45, 78, 94, 44, 11, 45, 78, 11);
		

		
		Map<Object, Long> groupedNums = list.stream().collect(Collectors.groupingBy((num) -> num,Collectors.counting()));
		
		groupedNums.forEach((key, value) -> {
			System.out.println("Number "+key+", occurred till "+value);
		});
	}

	private static void giveNumberOccuranceEx02() throws Exception{
		List<Integer> list = Arrays.<Integer>asList(11, 45, 67, 11, 44, 45, 78, 94, 44, 11, 45, 78, 11);
		
		Function<Integer, Integer> fn = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer num) {				
				return num;
			}
			
		}; 
		
		Map<Object, Long> groupedNums = list.stream().collect(Collectors.groupingBy(fn,Collectors.counting()));
		
		groupedNums.forEach((key, value) -> {
			System.out.println("Number "+key+", occurred till "+value);
		});
	}
	
	public static void main(String[] args) {
		try {
			giveNumberOccuranceEx01();
			giveNumberOccuranceEx02();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
