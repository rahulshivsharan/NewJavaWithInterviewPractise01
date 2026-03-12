package com.cx.fn.interview.ex16;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InterviewMainEx01 {

	public static void main(String[] args) {
		try {
			List<Integer> numList = Arrays.asList(12, 45, 56, 78, 89, 90, 91, 34, 21, 67);
			Optional<Integer> optionalVal = numList.stream().reduce((num1, num2) -> (num1+num2));
			System.out.println(optionalVal.get());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
