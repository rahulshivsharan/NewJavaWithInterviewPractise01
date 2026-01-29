package com.cx.fn.filter.ex10;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InterviewQuestion01 {
	
	private static class CustomerVO{
		private Integer customerId;
		private String[] productIds;
		
		public CustomerVO(Integer customerId, String[] productIds) {
			this.customerId = customerId;
			this.productIds = productIds;
		}

		public Integer getCustomerId() {
			return customerId;
		}

		public String[] getProductIds() {
			return productIds;
		}
		
		
	}
	
	/**
	 * Given the list of Customer Objects containing list of Products,
	 * give the output of all the products of all the customers as one list
	 * @throws Exception
	 */
	private static void assembleProducts() throws Exception{
		List<CustomerVO> numlist = Arrays.<CustomerVO>asList(
				new CustomerVO(12, new String [] { "011", "012", "013" }),
				new CustomerVO(13, new String [] { "021", "022", "023" }),
				new CustomerVO(14, new String [] { "031", "021", "033" }),
				new CustomerVO(15, new String [] { "041", "042", "043" }),
				new CustomerVO(16, new String [] { "051", "033", "053" }),
				new CustomerVO(17, new String [] { "031", "012", "013" })
				);

		// Pick array of departmentId's from every Customer Object in the list
		// and print it
		List<String> thelist = numlist.stream().map((vo) -> vo.getProductIds()).flatMap(Arrays::stream).collect(Collectors.toList());

		thelist.stream().forEach((dept) -> System.out.print(dept+", "));
		
		
		// Pick array of departmentId's from every Customer Object  
		// and make a unique collection of departmentId's by using Set
		Set<String> depts = numlist.stream().map((vo) -> vo.getProductIds()).flatMap(Arrays::stream).collect(Collectors.toSet());		
		depts.stream().forEach((dept) -> System.out.print(dept+", "));
	}

	public static void main(String[] args) {
		try {
			assembleProducts();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
