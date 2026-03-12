package com.cx.fn.interview.ex15;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InterviewMainEx01 {

	public static void main(String[] args) {
		try {
			List<Integer> numList = Arrays.asList(12, 45, 56, 78, 89, 90, 67);
			
			Map<Boolean, List<Integer>> map  = numList.stream().collect(Collectors.partitioningBy((num) -> {
				return num%2 ==0;
			}));
			
			System.out.println("Even Numbers "+map.get(true));
			System.out.println("Odd Numbers "+map.get(false));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
