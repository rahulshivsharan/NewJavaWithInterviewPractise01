package com.cx.fn.filter.ex09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Interview question on intelify.
 * 
 * For given list of strings, create a group of anagrams.
 * 
 * Example
 * 
 * Input is ["Car", "Litee", "Pan", "Elite", "Rac", "Nap", "Tilee", "Xam"]
 * Output will be 
 * [	[Car, Rac], 
 * 		[Litee, Elite, Tilee], 
 * 		[Pan, Nap], 
 * 		[Xam]
 * ]
 */
public class InterviewQuestion03 {
	
	/**
	 * Is the string found in the List of strings
	 * @param toBeSearched
	 * @param list
	 * @return
	 */
	private static boolean isFoundInList(String toBeSearched, List<String> list) {
		boolean found = false;
		
		for(int x = 0; x < list.size(); x++) {
			String str = list.get(x);
			if(str.equals(toBeSearched)) {
				found = true;
				break;
			}
		}
		
		return found;
	}


	public static void main(String[] args) {
		try {
			
			List<String> nameList = Arrays.asList("Car", "Litee", "Pan", "Elite", "Rac", "Nap", "Xam", "Tilee");	// given Input array		
			
			Map<String, List<String>> mapOfStrings = new LinkedHashMap<String, List<String>>(); // Map for grouping anagrams
			
			int totalNames = nameList.size();
			
			/**
			 *      Iterating through the list
			 *      to check anagrams and group them
			 */
			for (int i = 0; i < totalNames; i++) {

				String str = nameList.get(i);

				String strOneLowerCase = str.toLowerCase(); // convert string to lower case

				char[] charactersOfStr = strOneLowerCase.toCharArray(); // convert string to character array

				Arrays.sort(charactersOfStr); // Sort array of characters

				String sortedStr = Arrays.toString(charactersOfStr); // convert to string

				// Store in map
				if (mapOfStrings.get(sortedStr) == null) {
					List<String> list = new ArrayList<String>();
					list.add(str);
					mapOfStrings.put(sortedStr, list);
				} else {
					List<String> group = mapOfStrings.get(sortedStr);
					boolean found = isFoundInList(str, group);

					if (found == false) {
						group.add(str);
					}
				}

			}
						
			System.out.println(mapOfStrings.values()); 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
