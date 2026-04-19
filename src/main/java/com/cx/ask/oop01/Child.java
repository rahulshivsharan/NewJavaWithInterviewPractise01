package com.cx.ask.oop01;

public class Child extends Parent{
	
	
	public static void hello() {
		System.out.println("Hello From Child");
	}
	
	@Override
	public void hello(String name) {
		System.out.println("Hello From Child to "+name);
	}
}
