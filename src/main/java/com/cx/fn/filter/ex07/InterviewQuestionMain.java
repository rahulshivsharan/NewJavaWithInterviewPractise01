package com.cx.fn.filter.ex07;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class InterviewQuestionMain {
	private static Function<Integer, Predicate<Long>> numberStartsWith(){
		return  (Integer n) -> {
			
			return (num) -> {
				boolean isResultFound = false;		
				do {
					num =  (num / 10);			
					if(num > 10) {				
						continue;
					}else{
						isResultFound = true;				
					}
				}while(isResultFound == false);				
				
				return (num == Long.valueOf(n));
			}; 			
			
		};
	}
	
	public static void main(String [] args) {
		try {
List<Long> numbers = Arrays.<Long>asList(123456l, 175747l, 92341l, 335355l, 84345l, 1175675l, 74455l, 10766l, 207890l ,106334l, 11504l, 56223l, 144534l);
			
			System.out.println("Numbers starting from 1");
			numbers.stream().filter(InterviewQuestionMain.numberStartsWith().apply(1)).forEach(System.out::println);
			
			System.out.println("\nNumbers starting from 9");
			numbers.stream().filter(InterviewQuestionMain.numberStartsWith().apply(9)).forEach(System.out::println);
			
			System.out.println("\nNumbers starting from 5");
			numbers.stream().filter(InterviewQuestionMain.numberStartsWith().apply(5)).forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
