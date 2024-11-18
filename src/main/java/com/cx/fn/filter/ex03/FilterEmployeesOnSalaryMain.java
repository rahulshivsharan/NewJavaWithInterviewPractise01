package com.cx.fn.filter.ex03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.cx.vo.EmployeeVO;

public class FilterEmployeesOnSalaryMain {
	public static void main(String [] args) {
		try {
			List<EmployeeVO> empList =  Arrays.<EmployeeVO>asList(	new EmployeeVO(12, "Samatha N", 23, 3455.00),
					new EmployeeVO(32, "Alex P", 43, 5655.00),
					new EmployeeVO(2, "Usman B", 27, 1755.00),
					new EmployeeVO(21, "Abaline O", 35, 8155.00)
					);
			
			Predicate<EmployeeVO> isSalaryGreaterThan = (employeeVO) -> {
				return employeeVO.getSalary() >= 5000;
			};
			
			Predicate<EmployeeVO> isAgeGreaterThanForty = (employeeVO) -> {
				return employeeVO.getEmployeeAge() >= 40;
			};
			
			List<EmployeeVO> filteredEmployee = empList.stream().filter(isSalaryGreaterThan).collect(Collectors.toList());
			filteredEmployee.forEach(System.out::println);
			
			System.out.println("----------------------------------------\n");
			
			filteredEmployee = empList.stream().filter(isSalaryGreaterThan).filter(isAgeGreaterThanForty).collect(Collectors.toList());
			filteredEmployee.forEach(System.out::println);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
