package com.cx.ask.fn10;

public class MathOperation {
	/**
	 * Multiplication of two numbers without using 
	 * multiplication 'x' operator. Using tail recurrsion 
	 * @param num1
	 * @param num2
	 * @param accumulator
	 * @return
	 */
	public static TailCall<Integer> multiply(int num1, int num2, int accumulator){
		
		if(num1 == 0) {
			return TailCalls.done(accumulator);
		}
		
		TailCall<Integer> tailCall = () -> {
			return MathOperation.multiply(num1 - 1, num2, accumulator + num2);
		};
		
		return TailCalls.call(tailCall);
	}
	
	/**
	 * Calculating the square of number without using 
	 * raise to '^' operator and multiplication 'x' operator
	 * @param num
	 * @return
	 */
	public static TailCall<Integer> squareOf(int num){		
			return multiply(num, num, 0);
	}
}
