package com.cx.fn.interview.ex05;

import java.util.Arrays;

public class NeoSoftTestMainEx01 {
	
	public static int multiply(int [] nums) {
		int product = 1;
		
		if(nums.length > 1) {
			int [] n = Arrays.copyOfRange(nums, 1, nums.length);
			product = multiply(n) * nums[0]; 
		}else {
			product = nums[0];
		}
		return product;
	}	

	public static void main(String[] args) {
		System.out.println("Neosoft Hi");
		
		int product = 0;
		int [] numArray = new int[] {1, 2, 3, 4}; 
		int [] results = new int[numArray.length];

		for(int i = 0; i < numArray.length; i++){
			
			if(i == 0){
				
				int [] nums = Arrays.copyOfRange(numArray, 1, numArray.length);
				product = multiply(nums);
				results[i] = product;

			}else if (i > 0 && (i < numArray.length - 1)){
				int startIndex = 0;
				int[] nums1 = Arrays.copyOfRange(numArray,startIndex, i);
				startIndex = (i+1);
				int[] nums2 = Arrays.copyOfRange(numArray, startIndex, numArray.length);
				product = multiply(nums1) * multiply(nums2);
				results[i] = product;
			
			}else{
				
				int[] nums1 = Arrays.copyOfRange(numArray,0, i);
				product = multiply(nums1);
				results[i] = product;
			}
			
		}

		for(int i = 0; i < results.length; i++){
			System.out.println("Result of index "+i+" is "+results[i]+" ");
		}
	}

}
