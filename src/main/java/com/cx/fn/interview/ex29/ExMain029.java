package com.cx.fn.interview.ex29;

import java.util.List;

public class ExMain029 {

	private static void first() {
		var num = List.of(1, 2, 3, 4).stream().map((x) -> {
			System.out.println("map: " + x);
			return (x * 2);
		}).filter((n) -> {
			System.out.println("filter: " + n);
			return n > 4;
		}).allMatch((nm) -> {
			System.out.println("allMatch: " + nm);
			return nm > 6;
		});

		System.out.println(num);
	}
	
	
	private static void second() {
		var num = List.of(1, 2, 3, 4).stream().filter((n) -> {
			System.out.println("filter: " + n);
			return (n * 2) > 4;
		}).map((x) -> {
			System.out.println("map: " + x);
			return (x * 2);
		}).allMatch((nm) -> {
			System.out.println("allMatch: " + nm);
			return nm > 6;
		});

		System.out.println(num);
	}
	
	public static void main(String[] args) {
		//first();
		second();
	}

}
