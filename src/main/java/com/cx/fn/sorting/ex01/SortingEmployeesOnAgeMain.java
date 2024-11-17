package com.cx.fn.sorting.ex01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.cx.vo.EmployeeVO;

public class SortingEmployeesOnAgeMain {

	public static void main(String[] args) {
		List<EmployeeVO> empList =  Arrays.<EmployeeVO>asList(	new EmployeeVO(12, "Samatha N", 23, 3455.00),
																new EmployeeVO(32, "Alex P", 43, 3655.00),
																new EmployeeVO(2, "Usman B", 27, 3755.00),
																new EmployeeVO(21, "Abaline O", 35, 3155.00)
														); 
		
		
		List<EmployeeVO> sortedList = empList.stream().sorted((e1,e2) -> {
			return (e1.getEmployeeAge().compareTo(e2.getEmployeeAge())); 
		}).collect(Collectors.toList());
		
		for(EmployeeVO vo : sortedList) {
			System.out.println(vo);
		}
		System.out.println(".......................................\n");
		for(EmployeeVO vo : empList) {
			System.out.println(vo);
		}
	}

}
