package com.cx.ask.fn01;

import java.util.function.Consumer;
import java.util.function.Function;

public class MainEx03 {
	
	/**
	 * This method takes and input argument, a functional argument and a consumer functional argument which prints the message
	 * @param inputName
	 * @param processorFn
	 * @param printer
	 */
	private static void processAndPrint(String inputName, Function<String, String> processorFn, Consumer<String> printer) {
		String outputString = processorFn.apply(inputName);
		printer.accept(outputString);
	}
	
	public static void main(String [] args) {
		
		/*
		 * Lambda expression which takes input and returns output
		 * */		
		Function<String, String> fn = (name) -> {
			StringBuilder strb = new StringBuilder();
			
			strb.append("How are you ")
				.append(name)
				.append(" ?");
			
			return strb.toString();
		};
		
		processAndPrint("Victoria", fn, System.out::println);
	}
}
