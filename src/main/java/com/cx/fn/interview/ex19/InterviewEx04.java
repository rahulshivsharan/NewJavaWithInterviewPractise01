package com.cx.fn.interview.ex19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class InterviewEx04 {

	public static void main(String[] args) {
		try {
			String str = " Java articles are Awesome";
			
			String lowerstr = str.toLowerCase().trim().replaceAll("\\s+", "");
			
			List<String> alphabetList = lowerstr.chars().mapToObj(charVal -> {
				char ch = (char) charVal;
				return String.valueOf(ch);
			}).collect(Collectors.toList());
			
			
			
			Optional<Entry<String, List<String>>> entryOpt = alphabetList.stream()
																			.collect(Collectors.groupingBy((c) -> c))
																			.entrySet()
																			.stream()
																			.sorted((entry1, entry2) -> {
																				Integer count2 = entry2.getValue().size();
																				Integer count1 = entry1.getValue().size();
																				return count2.compareTo(count1);
																			}).findFirst();
			
			if(entryOpt.isPresent()) {
				Entry<String, List<String>> entryObj =  entryOpt.get();
				String alphabet = String.valueOf(entryObj.getKey());
				int count = entryObj.getValue().size();
				System.out.println(alphabet+" : "+count);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
