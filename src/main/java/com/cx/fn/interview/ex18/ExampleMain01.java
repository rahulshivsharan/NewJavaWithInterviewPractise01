package com.cx.fn.interview.ex18;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleMain01 {

	
	private static void approach01() throws Exception{
		List<Integer> list1 = Arrays.asList(34, 12, 89, 45, 22, 78);
		List<Integer> list2 = Arrays.asList(31, 21, 98, 54, 23, 87);
		
		List<Integer> mergeList = Stream.concat(list1.stream(), list2.stream()).toList();
		mergeList.stream().sorted().forEach(System.out::println);
	}
	
	
	private static void approach02() throws Exception{
		List<Integer> list1 = Arrays.asList(34, 12, 89, 45, 22, 78);
		List<Integer> list2 = Arrays.asList(31, 21, 98, 54, 23, 87);
		
		List<Integer> mergeList = Stream.of(list1.stream(), list2.stream())
										.flatMap((stream) -> stream)
										.collect(Collectors.toList());
		
		mergeList.stream().sorted().forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		try {
			//approach01();
			approach02();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
