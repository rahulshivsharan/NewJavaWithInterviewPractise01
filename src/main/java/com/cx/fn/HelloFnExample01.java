package com.cx.fn;

import java.util.function.Function;

public class HelloFnExample01 {

	private static void doubleNum() {
		
		Function<Integer, Integer> doubleNum = new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer num) {
				return num * 2;
			}			
			
		};
		
		System.out.println(doubleNum.apply(45));
	}
	
	
	private static void doubleNumInChain() {
		
		Function<Integer, Integer> doubleNum = new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer num) {
				return num * 2;
			}			
			
		};
		int num = doubleNum.andThen(doubleNum).andThen(doubleNum).apply(20);
		
		System.out.println(num);
	}
	
	private static void concateInChain() {
		
		Function<String, String> doubleStr = new Function<String, String>() {
			
			@Override
			public String apply(String str) {
				return str.concat(str);
			}			
			
		};
		String str = doubleStr.andThen(doubleStr).andThen(doubleStr).apply("2,");
		
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		try {
			//doubleNum();
			//doubleNumInChain();
			concateInChain();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
