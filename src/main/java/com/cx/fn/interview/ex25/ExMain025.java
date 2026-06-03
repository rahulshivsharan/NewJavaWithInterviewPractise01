package com.cx.fn.interview.ex25;

import java.util.List;
import java.util.stream.Collectors;

import com.cx.vo.Pair;


/**
 * even when we use parallel stream,
 * the exception of duplicate key occures but at different stages.
 * 
 * Because of Parallel Stream, there can be multiple threads working behind.
 * Each thread creates his own map
 * Thread A -> HashMap A
 * Thread B -> HashMap B
 * 
 * Thread A -> (1, 2), (1, 3)
 * Thread B -> (2, 4)
 * 
 * Even within single thread duplicate key causes immediate exception
 * 
 * Thread A -> (1, 2)
 * Thread B -> (1, 3)
 * 
 * In seperate thread the duplicate key exception occurres during merging
 * 
 * Thread A -> 	(1, 2), 
 * 				(1, 3)  <- exception occurres
 * 
 *  Thread A -> (1, 2)
 * 	Thread B -> (1, 3)
 * 
 *  mapA.merge(mapB) <- Exception occurres 
 */


public class ExMain025 {
	
	public static void main(String[] args) {
		try {
			var pairs = List.of(Pair.of(1, 2), 
								Pair.of(1, 3), 
								Pair.of(2, 4));

			var map = pairs.parallelStream().collect(Collectors.toMap(Pair::getKey, Pair::getValue));			
			map.forEach((k, v) -> System.out.println(k + " : " + v));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
