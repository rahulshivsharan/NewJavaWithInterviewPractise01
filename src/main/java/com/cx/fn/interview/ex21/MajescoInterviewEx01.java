package com.cx.fn.interview.ex21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a code where 
 * 
 * For input "23" the output is [ad, ae, af, bd, be, bf, cd, ce, cf]
 * For input "546" the output is [jgm, jgn, jgo, jhm, jhn, jho, jim, jin, jio, kgm, kgn, kgo, khm, khn, kho, kim, kin, kio, lgm, lgn, lgo, lhm, lhn, lho, lim, lin, lio ]
 * For input "3" the output is [d, e, f]
 */
public class MajescoInterviewEx01 {

	private static final Map<Integer, String []> numMap;
	
	
	static {
		numMap = new HashMap<Integer, String[]>();
		numMap.put(2, new String [] { "a", "b", "c" });
		numMap.put(3, new String [] { "d", "e", "f" });
		numMap.put(4, new String [] { "g", "h", "i" });
		numMap.put(5, new String [] { "j", "k", "l" });
		numMap.put(6, new String [] { "m", "n", "o" });
		numMap.put(7, new String [] { "p", "q", "r", "s"});
		numMap.put(8, new String [] { "t", "u", "v", "w" });
		numMap.put(9, new String [] { "y", "x", "z" });
	}
	
	/**
	 * The below method is called recursively
	 * @param inputNumStr
	 * @param totalDigits
	 * @return
	 */
	private static String [] concateCharacters(String inputNumStr, int totalDigits) {
		
		/* Example, if input number is "257" 
		 * then get first digit which is "2"
		 *  */
		String digitStr = inputNumStr.substring(0, 1); 
		
		// get characters mapped to number
		String [] charachters = numMap.get(Integer.parseInt(digitStr));
		
		if(totalDigits > 1) {
			
			// Example, if number is "257" then get "57"
			digitStr = inputNumStr.substring(1, totalDigits); 
			
			// Example, input "57" and its length which is 2
			String [] returnedCharacters = concateCharacters(digitStr, digitStr.length()); // call recursively 
			
			List<String> charList = new ArrayList<String>();
			
			for(int i = 0; i < charachters.length; i++) {
				for(int j = 0; j < returnedCharacters.length; j++) {
					
					StringBuffer strb = new StringBuffer();					
					strb.append(charachters[i])
						.append(returnedCharacters[j]);
					
					charList.add(strb.toString());
				}
			}
			charachters = charList.stream().toArray(String []::new);
		}
		
		
		return charachters;
	}
	
	public static void main(String[] args) {
		try {
			String inputNumStr = "27";			
			String [] characters = concateCharacters(inputNumStr, inputNumStr.length());
			
			for(int i = 0; i < characters.length; i++) {
				System.out.print(characters[i]+", ");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
