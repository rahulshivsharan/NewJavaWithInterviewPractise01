package com.cx.fn.interview.ex08;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This was a interview question
 * here for a input as a array of numbers I need to find
 * the first unique number
 * For input number array [5, 4, 5, 1, 2, 0, 4 ] 
 * the output is 1
 */
public class InterviewExample01 {
	
	/**
	 * Implementation using lambda 
	 * for given array of numbers find 
	 * the first unique number
	 * @throws Exception
	 */
	private static void secondAttempt() throws Exception{
		Integer[] nums = new Integer[] { 5, 4, 5, 1, 2, 0, 4 };
		
		List<Integer> numList = Arrays.asList(nums);
		
		/**
		 * function just returning the input as output
		 */
		Function<Integer, Integer> fn = new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer num) {
				return num;
			}
		};
		
		/**
		 * filtering out Entry objects where value is 1
		 */		
		Predicate<Map.Entry<Integer, Long>> filterSingleOccurance = new Predicate<Map.Entry<Integer,Long>>() {
			
			@Override
			public boolean test(Entry<Integer, Long> entryObj) {
				Long occuranceCount = entryObj.getValue();
				return (occuranceCount == 1) ? true : false;
			}
		};
		
		Optional<Integer> firstUnique =  numList.stream()
										 		.collect(Collectors.groupingBy(fn, LinkedHashMap::new, Collectors.counting()))
										 		.entrySet()
										 		.stream()
										 		.filter(filterSingleOccurance)
										 		.map(Map.Entry::getKey)
										 		.findFirst();
						
		System.out.println(firstUnique.get());
		
	}
	
	/**
	 * The below method is just a plain implementation of
	 * code where for a given array of numbers find the 
	 * first unique number
	 * @throws Exception
	 */
	private static void firstAttempt() throws Exception {
		Integer[] nums = new Integer[] { 5, 4, 5, 1, 2, 0, 4 };

		// declring linked hashmap to store Key-Value is ordered insertion
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

		// iterate through array of numbers and store 
		// key as num and value as number of times 
		// the number occurred in array
		for (Integer num : nums) {
			Integer count = map.get(num);

			if (count == null) {
				count = 1;
				map.put(num, count);
			} else {
				map.put(num, ++count);
			}

		}
		
		Integer numVal = null; // final output
		
		Set<Map.Entry<Integer, Integer>> entry = map.entrySet();

		// iterating through the key-value and check
		// which numbers count is 1 and break the loop
		for (Iterator<Map.Entry<Integer, Integer>> itr = entry.iterator(); itr.hasNext();) {
			Map.Entry<Integer, Integer> entryObj = itr.next();
			int count = entryObj.getValue();
			int val = entryObj.getKey();
			if (count == 1) {
				numVal = val;
				break;
			} else {
				continue;
			}
		}

		System.out.println(numVal);

	}

	public static void main(String[] args) {
		try {
			//firstAttempt();
			secondAttempt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
