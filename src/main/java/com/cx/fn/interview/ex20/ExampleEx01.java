package com.cx.fn.interview.ex20;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleEx01 {

	public static void main(String[] args) {
		try {
			List<Integer> list = Arrays.asList(2, 5, 3, 4, 3, 2, 8, 6, 3, 8, 1, 2, 5, 3, 6);
			Integer maxOccurredNum =  	list.stream().collect(Collectors.groupingBy(num -> num))
											 .entrySet()
											 .stream()
											 .sorted((entry1, entry2) -> {
												 Integer size1 = entry1.getValue().size();
												 Integer size2 = entry2.getValue().size();
												 return size2.compareTo(size1);
											 }).findFirst().get().getKey();
			
			System.out.println("Max num "+maxOccurredNum);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
