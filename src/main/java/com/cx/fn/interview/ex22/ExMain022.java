package com.cx.fn.interview.ex22;

import java.util.List;
import java.util.function.Function;

public class ExMain022 {

	public static void main(String[] args) {
		try {
			//first();
			second();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Java streams work (lazy evaluation + short-circuiting).
	 * 1. Streams are lazy
	 *	  Intermediate operations like filter() and map() do nothing immediately.
	 *	  Processing starts only when a terminal operation is called — here, findFirst().
	 *
	 * 2. findFirst() is a short-circuiting terminal operation
	 *	  
	 *	  findFirst():
	 *	  Stops processing as soon as it finds the first matching element.
	 *	  It does NOT process the entire stream.
	 *
	 * 3. Elements are processed one-by-one, not in bulk
	 *	  
	 *	  The stream processes elements like a pipeline:
	 *	  
	 *	  For each element:
	 *		Take first element → 1
	 *					
	 *		filter(num > 5) → ❌ false → discarded
	 *		map() is NOT called
     *
	 *		Next → 2			
	 *		❌ discarded		
	 *		
	 *		3, 4, 5			
	 *		❌ discarded
	 *					
	 *		Next → 6			
	 *		✅ passes filter (> 5)
	 *		✅ goes to map() → logAndReturn(6)
	 *		
	 * 4. What happens inside map()	
 	 *		"1. hello 6" is printed ✅
	 *		 Thread sleeps for 1 second
	 *		"2. hello 6" is printed ✅
	 *		Returns 6
	 *		
	 * 5. Why only ONE "hello"?
	 *		Because:
	 *		findFirst() stops after the first valid element (6)
	 *		No further elements (7, 8, 9, 10) are processed
	 *		So map() is called only once	 		
	 *	  
	 * Summary
	 *	"hello" is printed only once because:
	 *		1. Streams are lazy
	 *		2. Operations are applied element-by-element
	 *		3. findFirst() stops after the first match
	 *		4. Only the first matching value (6) reaches map()
	 */
	private static void first() {
		var list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		var res = list.stream().filter(ExMain022::filterFn)
							   .map(ExMain022::logAndReturn)
							   .findFirst()
							   .orElse(null);
		
		System.out.println("Result: "+res);
	}
	
	
	/*
	 * parallel execution + ordering constraints.
	 * 
	 * 1. Parallel streams process elements out of order
		  Work is split across multiple threads
		  Elements may be processed simultaneously
		  Execution order is not guaranteed internally

		  So elements like 6, 7, 8, 9, 10 may all be processed at the same time
		  
	   2. BUT findFirst() still preserves order
		  
		  This is critical:
		  findFirst() = order-sensitive operation
		  Even in parallel, it must return the first element in encounter order
		  
		  In your list: [1,2,3,4,5,6,7,8,9,10]
		  The first element > 5 is 6, so result must be 6.
		  
		  In sequential stream:
		  Elements processed one-by-one
		  Stops immediately when 6 is found
		  Only one "hello"
		  
		  In parallel stream:
		  Multiple elements are processed concurrently
		  Several threads may already be executing map()
		  before findFirst() decides to stop
		  
		  What actually happens internally
		  Think of it like this:
		  Threads pick chunks:
		  
		  Thread A → [1,2,3]
		  Thread B → [4,5,6]
		  Thread C → [7,8]
		  Thread D → [9,10]
		  
		  Now:

		  Thread B processes 6 → ✅ matches → calls map() → prints "hello"
		  BUT at the same time:
		  Thread C may already be processing 7
          Thread D may already be processing 9
		  👉 So multiple map() calls can happen before cancellation kicks in
		  
		  
	 */
	private static void second() {
		var list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		var res = list.parallelStream().filter(ExMain022::filterFn)
									   .map(ExMain022::logAndReturn)
									   .findFirst()
									   .orElse(null);
		
		System.out.println("Result: "+res);
	}
	
	private static Integer logAndReturn(Integer value) {		
		try {
			System.out.println("1. hello "+value);
			Thread.sleep(1000L);
			System.out.println("2. hello "+value);
		}catch(InterruptedException ignoreEx) {
			
		}
		return value;
	}

	
	private static boolean filterFn(Integer num) {
		System.out.println("Filtering num "+num);
		return (num > 5);
	}
}
