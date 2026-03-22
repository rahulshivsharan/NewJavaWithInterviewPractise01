package com.cx.fn.interview.ex19;

import java.util.Arrays;
import java.util.List;


public class InterviewEx05 {


	private static boolean isPrimeFn(Integer num) {
		boolean isPrime = true;
		int n = (num/2);
		
		if(num == 2 || num == 3 || num == 5) return true;
		
		if((num <=1) || (num%2 == 0) || (num%3 == 0) || (num%5 == 0)) {
			return false;
		} 
		
		
		do {
			
			if((num%n) == 0) {
				isPrime = false;
				break;
			}
			n--;
		}while(n >= 2);
		
		return isPrime;
	}
	
	private static boolean checkPrimeFn(Integer num) {
		boolean isPrime = true;		
		
		if(num == 2 || num == 3 || num == 5) return true;
		
		if((num <=1) || (num%2 == 0) || (num%3 == 0) || (num%5 == 0)) {
			return false;
		} 
		
		int n = 3;
		while((n*n) <= num) {
			
			if(num%n == 0) {
				isPrime = false;
				break;
			}
						
			n = n + 2; //odd number 
		}
		
		return isPrime;
	}
	
	
	
	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(12, 5, 33, 47, 38, 16, 57, 61);
		 
		//numList.stream().filter(InterviewEx05::isPrimeFn).forEach(System.out::println);
		numList.stream().filter(InterviewEx05::checkPrimeFn).forEach(System.out::println);
		
	}

}
