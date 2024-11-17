package com.cx.fn.filter.ex02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OddNumFilterMain {

	public static void main(String[] args) {
		try {
			List<Integer> nums = Arrays.asList(12,34,56,78,37,43,77,91);
			
			nums = nums.stream().filter((num) ->{
				return ((num%2) != 0);
			}).collect(Collectors.toList());
			
			for(Integer num : nums) {
				System.out.println(num);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
