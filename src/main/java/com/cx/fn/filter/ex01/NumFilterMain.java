package com.cx.fn.filter.ex01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumFilterMain {

	public static void main(String[] args) {
		try {
			List<Integer> nums = Arrays.asList(12,45,67,98,46,77);
			EvenNumPredicate predicate = new EvenNumPredicate();
			nums = nums.stream().filter(predicate).collect(Collectors.toList());
			for(Integer num : nums) {
				System.out.println(num);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
