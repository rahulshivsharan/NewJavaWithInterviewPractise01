package com.cx.ask.fn11;

public class MainEx01 {

	public static void main(String[] args) {
		int num = 2345612;
		System.out.println("Number "+num+" is Even "+MutualRecursion.isEven(num).invoke());
		
		num = 23456121;
		System.out.println("Number "+num+" is Odd "+MutualRecursion.isOdd(num).invoke());
		
	}

}
