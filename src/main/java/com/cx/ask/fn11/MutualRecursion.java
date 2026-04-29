package com.cx.ask.fn11;


/**
 * It contains two methods isEven and isOdd
 * that call each other recursively
 */
public class MutualRecursion {
	
	/*
	 * isEven method calls isOdd inside lambda and returns lambda
	 */
	public static TailCall<Boolean> isEven(int num){
		if(num == 0) {
			return TailCalls.done(true);
		}
		
		TailCall<Boolean> tailCall = () -> {
			return MutualRecursion.isOdd(num - 1);
		};
		
		return tailCall;
	}
	
	/*
	 * isOdd method calls isEven inside lambda and returns lambda
	 */
	public static TailCall<Boolean> isOdd(int num){
		if(num == 0) {
			return TailCalls.done(false);
		}
		
		TailCall<Boolean> tailCall = () -> {
			return MutualRecursion.isEven(num - 1);
		};
		
		return tailCall;
	}
}
