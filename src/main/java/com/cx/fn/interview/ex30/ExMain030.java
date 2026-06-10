package com.cx.fn.interview.ex30;

import java.util.List;

public class ExMain030 {

	private static void first() {
		var num = List.of(1, 2, 3, 4).stream().map((x) -> {
			System.out.println("map: " + x);
			return (x * 2);
		}).filter((n) -> {
			System.out.println("filter: " + n);
			return n > 4;
		}).noneMatch((nm) -> {
			System.out.println("noneMatch: " + nm);
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
		}).noneMatch((nm) -> {
			System.out.println("noneMatch: " + nm);
			return nm > 6;
		});

		System.out.println(num);
	}
	
	public static void main(String[] args) {
		//first();
		second();
	}

}
