package com.cx.fn.map.ex01;

import java.util.Arrays;
import java.util.List;

public class ExampleMapMain02 {

	public static void main(String[] args) {
		try {
			List<String> friends = Arrays.asList("Kristrof Jamson", "Viktor Kalanac", "Amber Utampik", "Viny Temberlane");
			
			friends.stream().map(String::toUpperCase).forEach(System.out::print);
			
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
