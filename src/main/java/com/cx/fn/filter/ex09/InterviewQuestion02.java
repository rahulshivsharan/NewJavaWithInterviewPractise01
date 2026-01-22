package com.cx.fn.filter.ex09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
public class InterviewQuestion02 {

	
	/**
	 * Check if two strings are anagram if yes, return true
	 * @param str1
	 * @param str2
	 * @return
	 */
	private static boolean isAnagram(String str1, String str2) throws Exception{
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		// if either string is null or not matching length return false
		if(str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}
		
		// if two strings are equal return true
		if(str1.equalsIgnoreCase(str2)) {
			return true;
		}
		
		int str_len = str1.length();
		int i = 0;
		
		// creating set to grab unique letters of strings
		Set<String> group = new HashSet<String>();
		
		
		// iterate through letters in string one, and add those in set
		while (i < str_len) {
			group.add(String.valueOf(str1.charAt(i)));
			i++;
		}
		
		// note down total count of unique letters of string one
		int intitialCharacterCount = group.size(); 
		
		// iterate through letters in string two, and add those in set
		i = 0;
		while (i < str_len) {
			group.add(String.valueOf(str2.charAt(i)));
			i++;
		}
		
		
		// compare of total number of characters in  
		if (intitialCharacterCount != group.size()) {			
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {		
		
		
		try {
			List<String> nameList = Arrays.asList("Car", "Litee", "Pan", "Elite", "Rac", "Nap", "Tilee", "Xam");

			// Maintains list containing groups
			List<List<String>> groupList = new ArrayList<List<String>>();

			do {
				// to create group of matched anagram strings
				List<String> group = new ArrayList<String>();

				// create a temporary list to maintain unmatched strings
				List<String> tempList = new ArrayList<String>();
				int totalItems = nameList.size();
				int counter = 0;
				int pointer = 0;

				String str1 = nameList.get(counter);
				group.add(str1);

				// of list contains only one string, create a group of one string and exit
				if (totalItems == 1) {
					groupList.add(group);
					break;
				}
				
				do {

					pointer++;
					String str2 = nameList.get(pointer);

					// if anagram match, group the matching strings
					if (isAnagram(str1, str2) == true) {
						group.add(str2);
					} else {
						// if not match maintain the unmatched temporary list
						tempList.add(str2);
					}

				} while (pointer < (totalItems - 1)); // iterate the main list till last character

				groupList.add(group); // add the group in group list

				nameList = new ArrayList<String>(); // re-intialise the main list
				nameList.addAll(tempList); // add all unmatched strings in main list
				tempList = new ArrayList<String>(); // re-intialise temporary list to zero

			} while (nameList.size() >= 1); // iterate the main list till size of main list is 1

			System.out.println(groupList);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
