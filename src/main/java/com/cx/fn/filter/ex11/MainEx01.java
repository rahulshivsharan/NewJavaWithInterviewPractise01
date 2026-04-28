package com.cx.fn.filter.ex11;

import java.util.function.Function;

public class MainEx01 {

	public static void main(String[] args) {
		try {
			int num = 5;
			Function<Integer, Integer> func = Summation::getSummationOf;
			
			System.out.println("Summation of number "+num+" is "+func.apply(num));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
