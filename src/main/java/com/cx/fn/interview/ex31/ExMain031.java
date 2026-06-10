package com.cx.fn.interview.ex31;

import java.util.stream.Stream;

public class ExMain031 {

	public static void main(String[] args) {
		//first();
		second();
	}

	private static void first() {
		Integer val = Stream.iterate(1, (i) -> {
			System.out.println("iterate: " + i);
			return i + 1;
		}).filter((i) -> {
			System.out.println("filter: " + i);
			return (i % 100 == 0);
		}).findFirst().get();

		System.out.println("Value " + val);
	}
	
	
	private static void second() {
		Stream.iterate(1, (i) -> {
			return i + 1;
		}).limit(100).filter((i) -> {
			return (i % 5 == 0);
		}).forEach(System.out::println);
	}
	
	
}
