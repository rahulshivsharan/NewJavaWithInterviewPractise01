package com.cx.fn.filter.ex04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewQuestionMain {
	
	private static boolean divisibleByTens(long num) {
		boolean isResultFound = false;		
		do {
			num =  (num / 10);			
			if(num > 10) {				
				continue;
			}else{
				isResultFound = true;				
			}
		}while(isResultFound == false);
		
		return (num == 1) ? true : false;
	}
	
	public static void main(String[] args) {
		try {
			List<Long> numbers = Arrays.<Long>asList(123456l, 175747l, 92341l, 335355l, 84345l, 1175675l, 74455l, 10766l, 207890l ,106334l, 11504l, 56223l, 144534l);
			
			List<Long> filteredNumbers = numbers.stream().filter(InterviewQuestionMain::divisibleByTens).collect(Collectors.toList());
			filteredNumbers.forEach(System.out::println);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
