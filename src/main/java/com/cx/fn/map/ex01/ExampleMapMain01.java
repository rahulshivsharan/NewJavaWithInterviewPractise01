package com.cx.fn.map.ex01;

import java.util.Arrays;
import java.util.List;

public class ExampleMapMain01 {

	public static void main(String[] args) {
		try {
			List<String> friends = Arrays.asList("Kristrof Jamson", "Viktor Kalanac", "Amber Utampik", "Viny Temberlane");
			
			int i = friends.stream().mapToInt((name) -> {
				return name.length();
			}).sum();
			
			System.out.println(i); 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
