package com.cx.ask.fn12;


public class MainEx01 {

	public static void main(String[] args) {
		int num1 = 4;
		int num2 = 3;
		System.out.println(num1+" X "+num2+" = "+MathOperation.multiply(num1, num2, 0).invoke());
		System.out.println(num1+" ^ "+num2+" = "+MathOperation.power(num1, num2, 1).invoke());
	}

}
