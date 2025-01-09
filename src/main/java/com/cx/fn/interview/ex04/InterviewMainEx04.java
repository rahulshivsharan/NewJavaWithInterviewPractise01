package com.cx.fn.interview.ex04;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Output is :
 * 
  	dd 1
	cc 1
	bb 2
	aa 3
 */
public class InterviewMainEx04 {
	public static void main(String [] args) {
		try {
			List<String> theList = Arrays.asList("aa", "bb", "cc", "bb", "aa", "dd", "aa");
			
			Map<String, Long> map = theList.stream().collect(Collectors.groupingBy((name) -> name,  Collectors.counting()));
			
			map.forEach((key, value) -> System.out.println(key+" "+value));			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
