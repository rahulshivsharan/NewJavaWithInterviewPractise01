package com.cx.fn.interview.ex20;

import java.util.Optional;



public class ExampleMainEx01 {
	
	private static void empty() throws Exception{
		Optional<String> emptyOptional = Optional.empty();
		
		if(emptyOptional.isEmpty()) {
			System.out.println("When Option is empty...");
		}
	}
	
	private static void present() throws Exception{
		Optional<String> optn = Optional.of("Rahul Shivsharan");
		
		if(optn.isEmpty()) {
			System.out.println("When Option is empty...");
		}else {
			System.out.println("Value of Option is "+optn.get());
		}
	}
	
	private static void getDefault() throws Exception{
		Optional<String> emptyOptional = Optional.empty();
		System.out.println("When Option is empty else "+emptyOptional.orElse("Default Value"));
		
	}

	public static void main(String[] args) {
		try {
			ExampleMainEx01.empty();
			ExampleMainEx01.present();
			ExampleMainEx01.getDefault();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
