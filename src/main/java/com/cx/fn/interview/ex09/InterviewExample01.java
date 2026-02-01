package com.cx.fn.interview.ex09;

import java.util.Arrays;

/**
 * For given list of stock pricess as input array, 
 * Give an output as the maximum profit 
 * For for example 
 * input array of stock values is [ 7, 1, 5, 3, 6, 4 ] 
 * The output is 5 i.e if we purchase stock at value '1' and sell at '6' 
 * this will yield me the highest stock.
 */
public class InterviewExample01 {

	
	private static void stockPrices02() throws Exception{
		Integer [] stockValueList = new Integer [] { 7, 1, 5, 3, 6, 4 };
		int totalStockValueItem = stockValueList.length;
		int maxProfit = 0;
		
		// interating through stock values
		for(int day = 0; day < totalStockValueItem - 1; day++) {
			int purchacedStockValue = stockValueList[day];
			int nextDay = day + 1;
			int lastDay = totalStockValueItem;
			
			// Get the subarray of future values of stock 
			Integer [] nextValues = Arrays.copyOfRange(stockValueList, nextDay, lastDay); 
			
			// sort the values in descending order
			Arrays.sort(nextValues, (num1, num2) -> {
				return num2.compareTo(num1);
			});			
			
			int maxStockValueInFuture = nextValues[0]; // denotes the max value of stock
			int currentProfit = maxStockValueInFuture - purchacedStockValue; // calculate the profit
			
			// check if the profit calculated is maximum or not
			if(maxProfit < currentProfit){
				maxProfit = currentProfit;
			}			
		}	
		System.out.println(maxProfit);
	}
	
	private static void stockPrices01() throws Exception{
		Integer [] stockValueList = new Integer [] { 2, 4, 1 };
		int totalStockValueItem = stockValueList.length;
		int maxProfit = 0;
		
		for(int day = 0; day < totalStockValueItem; day++) { // interating through stock values
			int stockPurchaseValue = stockValueList[day]; // picking the purchased stock
			
			// searching for future prices which will yield the highest profit
			for(int nextDay = (day+1); nextDay <= (totalStockValueItem -1); nextDay++) {
				
				int currentStockValue = stockValueList[nextDay]; // pick future price
				int currentProfit = currentStockValue - stockPurchaseValue; 
				if(currentProfit > maxProfit) {
					maxProfit =  currentProfit; // note the maximum profit
				}				 
			}
		}
		
		System.out.println(maxProfit);
	}
	
	public static void main(String[] args) {
		try {
			//stockPrices01();
			stockPrices02();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
