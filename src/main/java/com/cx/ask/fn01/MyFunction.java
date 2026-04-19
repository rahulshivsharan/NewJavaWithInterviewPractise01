package com.cx.ask.fn01;

import java.util.function.Function;

public class MyFunction implements Function<String, String>{

	@Override
	public String apply(String name) {
		StringBuffer strb = new StringBuffer();
		strb.append("Hi, how are you ").append(name).append(" ? ");
		return strb.toString();
	}
	
}
