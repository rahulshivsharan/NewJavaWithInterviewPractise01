package com.cx.ask.fn12;

/**
 * n * m is n + n + n.....m times
 * 4 * 3
 * 4 + 4 + 4
 */
public class MathOperation {
	public static TailCall<Integer> multiply(int num1, int num2, int accumulator){
		if(num2 == 0) {
			return TailCalls.done(accumulator);
		}
		
		TailCall<Integer> tailcall = new TailCall<Integer>() {
			
			@Override
			public TailCall<Integer> apply() {
				TailCall<Integer> tailCall = MathOperation.multiply(num1, num2 - 1, accumulator + num1);
				return tailCall;
			}
			
		};
		
		return TailCalls.call(tailcall);
	}
	
	/*
	 *  power i.e. (a)^b can be done by calling mutliply recursively
	 *   4^3
	 *   4 * 1 = 4
	 *   4 * 4 = 16
	 *  16 * 4 = 64
	 */
	public static TailCall<Integer> power(int base, int exponent, int accumulator){
		if(exponent == 0) {
			return TailCalls.done(accumulator);
		}
		
		TailCall<Integer> tailcall = new TailCall<Integer>(){
			
			@Override
			public TailCall<Integer> apply() {
				int num1 = base;
				int num2 = accumulator;
				Integer nextVal = MathOperation.multiply(num1, num2, 0).invoke();
				
				TailCall<Integer> tailCall = MathOperation.power(base, exponent - 1, nextVal);
				return tailCall;
			}
			
		};
		
		return TailCalls.call(tailcall);
	}
}
