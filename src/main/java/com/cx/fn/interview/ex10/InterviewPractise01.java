package com.cx.fn.interview.ex10;

import java.util.Arrays;
import java.util.Stack;

/**
 * for a input of string of brackets,
 * give count of opening and closing bracket in pair which forms a pattern
 * 
 * For example
 * input "))()()())))"
 * output 3
 */
public class InterviewPractise01 {
	
	private static final String OPENING_BRACKET = "(";
	private static final String CLOSING_BRACKET = ")";
	
	private static void checkBrackets(String pattern) throws Exception{
		Stack<String> stack = new Stack<String>();
		
		char [] arr = pattern.toCharArray();		
		int count = 0;
		
		
		// iterate through brackets array
		for(int i = 0; i < arr.length; i++) {
			String currentBracket = String.valueOf(arr[i]); // get the current bracket
			
			// push in stack if size is zero
			if(stack.size() == 0) {				
				stack.push(currentBracket);
			}
			
			if(stack.size() == 1) {
				String previousBracket = stack.pop(); // pop the previous bracket
				
				// check of we get "()" as pattern
				if(previousBracket.equals(OPENING_BRACKET) && currentBracket.equals(CLOSING_BRACKET)) {
					count++;
				}else {
					stack.push(currentBracket); // as the stack is empty push the current bracket
				}
			}
		}
		System.out.println("For pattern \""+pattern+"\", count is "+count);
	}


	
	public static void main(String[] args) {
		String[] pattern = new String[]{"))))())", "()))()))", "(()))()))", "))()()()()(((" };
		try {
			for(int i = 0; i< pattern.length; i++) {
				String bracketPattern = pattern[i];
				checkBrackets(bracketPattern);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
