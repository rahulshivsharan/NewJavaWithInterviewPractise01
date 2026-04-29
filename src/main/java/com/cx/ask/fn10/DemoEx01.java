package com.cx.ask.fn10;



public class DemoEx01 {

	public static void main(String[] args) {
		try {
			int num1 = 3;
			int num2 = 2;
			
			 TailCall<Integer> tailCall = MathOperation.multiply(num1, num2, 0);			 
			 System.out.println("Multiplication of "+num1+" X "+num2+" = "+tailCall.invoke());
			 
			 num1 = 12;
			 tailCall = MathOperation.squareOf(num1);
			 System.out.println(num1+"^2 is "+tailCall.invoke());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
