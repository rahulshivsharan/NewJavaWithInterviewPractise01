package com.cx.fn.interview.ex04;

import java.util.Arrays;
import java.util.List;

public class InterviewEx01 {

	/**
	 * Search a string in list of string's
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> nameList = null; 
		try {
			nameList = Arrays.asList("Tom", "Ben", "Jerry", "Nick", "Nelson", "Patrick", "Petre", "Sam");
			String searchIt = "Vicktor";
			boolean isPresent = nameList.stream().anyMatch(name -> name.equals(searchIt));
			System.out.println(isPresent);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
