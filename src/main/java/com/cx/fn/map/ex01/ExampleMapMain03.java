package com.cx.fn.map.ex01;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.cx.vo.EmployeeVO;


public class ExampleMapMain03 {

	/**
	 * The below code uses functional stream method to add numbers in an array
	 */
	private static void addAllNums() throws Exception{
		try {

			List<Integer> nums = Arrays.asList(12, 20, 50);

			int total = nums.stream().mapToInt((num) -> {
				return num;
			}).sum();

			System.out.println("Sum of Numbers " + total);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * The below method doubles the numbers present in the list
	 * @throws Exception
	 */
	private static void doubleTheNums() throws Exception{
		try {
			List<Integer> nums = Arrays.asList(12, 20, 50);
			List<Integer> numArray = nums.stream().map((num) -> {
				return num * 2;
			}).collect(Collectors.toList());
			
			numArray.forEach((num)->{
				System.out.print(num+", ");
			});
			System.out.println("\n");
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * Filter the even numbers from the list of numbers and print them.
	 * Here we have used inline predicate function to filter the numbers
	 * @throws Exception
	 */
	private static void filterEvenNums() throws Exception{
		try {
			List<Integer> nums = Arrays.asList(12, 16, 17 ,20, 25, 50, 56);
			List<Integer> numArray = nums.stream().filter((num) -> {
				return num%2 == 0;
			}).collect(Collectors.toList());
			
			
			numArray.forEach((num)->{
				System.out.print(num+", ");
			});
			System.out.println("\n");
		}catch(Exception e) {
			throw e;
		}
	}
	
	
	/**
	 * Filter the even numbers from the list of numbers and print them,
	 * Here I have written seperate predicate class from Predicate interface 
	 * @throws Exception
	 */
	private static void filterEvenNumbersUsingPredicate() throws Exception{
		try {
			
			Predicate<Integer> evenPredicate = new Predicate<Integer>() {
				
				@Override
				public boolean test(Integer num) {					
					return num%2 == 0;
				}
			};
			
			List<Integer> nums = Arrays.asList(12, 16, 17 ,20, 25, 50, 56);
			
			List<Integer> numArray = nums.stream().filter(evenPredicate).collect(Collectors.toList());
			
			
			numArray.forEach((num)->{
				System.out.print(num+", ");
			});
			System.out.println("\n");
		}catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * Sorting the list of employees on the basis of salary using
	 * lambda expression and assign to the list
	 * @throws Exception
	 */
	private static void sortEmployees() throws Exception{
		
		List<EmployeeVO> empList = Arrays.<EmployeeVO>asList(
				new EmployeeVO(123,"Xena Phobos", 32, 1400.00),
				new EmployeeVO(123,"Jitesh Pujara", 45, 1501.00),
				new EmployeeVO(123,"Kindle Overa", 47, 1356.00),
				new EmployeeVO(123,"Victor Smalish", 34, 2500.00),
				new EmployeeVO(123,"Ojeck Kepiere", 23, 4700.00)
				);
		
		List<EmployeeVO> list = empList.stream().sorted((employee1, employee2) -> {
			return employee1.getSalary().compareTo(employee2.getSalary());
		}).collect(Collectors.toList());
		
		list.forEach(System.out::println); // sorted list of employees according to salary 
		
		System.out.println(" ///// "); // original list
		
		empList.forEach(System.out::println);
	}
	
	/**
	 * Filter list of numbers which starts from 1
	 * @throws Exception
	 */
	private static void filterNumbersStartingFromOne() throws Exception{
		
		Predicate<Integer> logicFunc = new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer num) {				
				do {
					num = num/10;
				}while(num >= 10);
				
				return (num == 1) ? true : false;
			}
		};
		
		List<Integer> listOfNumbers = Arrays.asList(2345, 1675, 4353, 18754, 3435, 1003, 5355, 1393);
		
		List<Integer> filteredList = listOfNumbers.stream().filter(logicFunc).collect(Collectors.toList());
		
		filteredList.forEach((num) -> {
			System.out.print(" "+num);
		});
		
		System.out.print("\n\n ");
	}
	
	
	/**
	 * Filter list of numbers which starts from 1
	 * @throws Exception
	 */
	private static void filterNumbersEndingWithOne() throws Exception{
		
		Predicate<Integer> logicFunc = new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer num) {				
				do {
					num = num%10;
				}while(num > 10);
				
				return (num == 1) ? true : false;
			}
		};
		
		List<Integer> listOfNumbers = Arrays.asList(23451, 1675, 43531, 18754, 3435, 10031, 5355, 3931);
		
		List<Integer> filteredList = listOfNumbers.stream().filter(logicFunc).collect(Collectors.toList());
		
		filteredList.forEach((num) -> {
			System.out.print(" "+num);
		});
		
		System.out.print("\n\n ");
	}
	
	public static void main(String[] args) {
		try {
			//addAllNums();
			//doubleTheNums();
			//filterEvenNums();
			//filterEvenNumbersUsingPredicate();
			//sortEmployees();
			//filterEvenNumbersUsingPredicate();
			//filterNumbersStartingFromOne();
			filterNumbersEndingWithOne();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
