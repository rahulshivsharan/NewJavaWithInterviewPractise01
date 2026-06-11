package com.cx.fn.interview.ex33;

import java.util.stream.Stream;

public class ExMain033 {

	public static void main(String[] args) {
		int num = 6;
		System.out.println("Summation of "+num+" is "+summationOf(num));
	}
	
	private static int summationOf(int num) {
		return Stream.iterate(0, (n) -> {
			return n + 1; // acts as for-loop to iterate from 0, 1, 2, 3, 4, 5.. < num 
		}).limit(num).map((numN) -> {
			int next = numN + 1; // returns 1, 2, 3, 4, 5, 6.. <= num
			return next;
		}).reduce(0, (result, numberIterate) -> {
			return result + numberIterate; // keeps on adding numbers to 'result'
		}).intValue();
	}

}
