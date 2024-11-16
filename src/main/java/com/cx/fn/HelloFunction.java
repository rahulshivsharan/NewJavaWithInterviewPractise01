package com.cx.fn;

import java.util.function.Function;

public class HelloFunction implements Function<String, String>{

	@Override
	public String apply(String name) {
		StringBuffer strb = new StringBuffer();
		strb.append("Hello \"").append(name).append("\"");
		return strb.toString();
	}

}
