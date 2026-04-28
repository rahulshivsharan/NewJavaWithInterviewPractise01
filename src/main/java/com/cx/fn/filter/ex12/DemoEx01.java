package com.cx.fn.filter.ex12;

import java.util.function.BiFunction;
import java.util.function.Function;

public class DemoEx01 {

	public static void main(String[] args) {
		int num1 = 12;
		int num2 = 3;
		BiFunction<Integer, Integer, Integer> mutiplyFunc = Operation::mutiply;
		Function<Integer, Integer> squareOf = Operation::squareOfNum;
		
		System.out.println("Mutiplication of number "+num1+" X "+num2+" = "+mutiplyFunc.apply(num1, num2)); 
		
		System.out.println("Square of number "+num1+" = "+squareOf.apply(num1)); 
	}

}
