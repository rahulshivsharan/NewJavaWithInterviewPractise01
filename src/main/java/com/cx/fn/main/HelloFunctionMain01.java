package com.cx.fn.main;

import java.util.function.Function;

import com.cx.fn.HelloFunction;

public class HelloFunctionMain01 {	
	

	public static void main(String[] args) {
		Function<String, String> hello = new HelloFunction();
		System.out.println(hello.andThen(hello).apply("Vinit"));
	}

}
