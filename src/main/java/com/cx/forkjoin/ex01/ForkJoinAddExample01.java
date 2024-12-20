package com.cx.forkjoin.ex01;

import java.util.Arrays;
import java.util.stream.LongStream;


public class ForkJoinAddExample01 {

	public static void main(String[] args) {
		try {
			long result = ForkJoinAdd.startForkJoinSum(5);
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
