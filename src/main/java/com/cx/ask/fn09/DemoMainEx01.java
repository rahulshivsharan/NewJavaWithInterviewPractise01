package com.cx.ask.fn09;

public class DemoMainEx01 {
	
	public static TailCall<Integer> getSummationOf(int num, int accumulator){
		
		if(num == 0) {
			return TailCalls.done(accumulator);
		}
		
		TailCall<Integer> fn = () -> {
			return DemoMainEx01.getSummationOf(num - 1, accumulator + num);
		};
		
		return TailCalls.call(fn);
	}

	public static void main(String[] args) {
		int num = 5;
		int finalSum = 0;
		TailCall<Integer> tailCall = DemoMainEx01.getSummationOf(num, finalSum);
		System.out.println("Summation of number "+num+" is "+tailCall.invoke());
	}

}
