package com.cx.fn.ex08;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import com.cx.vo.EmployeeVO;

public class FunctionalExample08Main {
	
	/**
	 * From the list of employees, filter the those employees whose salararies are 
	 * greater then 5000, and output a map having 'employeeName' as key and 'employeeAge' as value.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			List<EmployeeVO> empList =  Arrays.<EmployeeVO>asList(	
						new EmployeeVO(12, "Samatha N", 23, 3455.00),
						new EmployeeVO(32, "Alex P", 43, 5655.00),
						new EmployeeVO(2, "Usman B", 27, 1755.00),
						new EmployeeVO(21, "Abaline O", 35, 8155.00),
						new EmployeeVO(24, "Igor V", 45, 6712.6),
						new EmployeeVO(18, "Patric H", 38, 4821.6)
					);
			
			// create a 'predicate' to filter employee having salary greater than 5000
			Predicate<EmployeeVO> predicateSalary = (vo) -> {
				return (vo.getSalary() >= 5000);
			};
			
			// created function which takes input as list of employees and the above predicate condition,
			// the function returns map.
			BiFunction<List<EmployeeVO>, Predicate<EmployeeVO>, Map<String, Integer>> mapBiFn = (voList, predicateObj) -> {
				Map<String, Integer> map = new HashMap<String, Integer>();
				voList.stream().filter(predicateObj).forEach((vo) -> {
					final String empName = vo.getEmployeeName();
					final Integer age = vo.getEmployeeAge();
					map.put(empName, age);  
				});
				return map;
			};
			
			
			System.out.println("Employee Earning more than 5000 salary");
			
			// call the function which returns map and iterate through the map
			mapBiFn.apply(empList, predicateSalary).entrySet().forEach((entryObj) -> {				
				System.out.println("Employee Name "+entryObj.getKey()+", is "+entryObj.getValue()+" years old");
			});
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
