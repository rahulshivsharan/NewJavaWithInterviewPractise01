package com.cx.ask.fn01;

import java.util.function.Function;

public class MainEx02 {

	public static void main(String[] args) {
		Function<String, String> fn = (name) -> {
			StringBuilder strb = new StringBuilder();
			strb.append("How are you ").append(name).append(" ?");
			return strb.toString();
		};
		
		System.out.println(fn.apply("Rocky"));
	}

}
