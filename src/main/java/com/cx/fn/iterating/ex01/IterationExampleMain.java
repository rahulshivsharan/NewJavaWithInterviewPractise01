package com.cx.fn.iterating.ex01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.cx.vo.EmployeeVO;

public class IterationExampleMain {

	public static void main(String[] args) {
		List<EmployeeVO> empList =  Arrays.<EmployeeVO>asList(	new EmployeeVO(12, "Samatha N", 23, 3455.00),
				new EmployeeVO(32, 	"Alex P", 	 43, 3655.00),
				new EmployeeVO(2, 	"Usman B", 	 27, 3755.00),
				new EmployeeVO(21, 	"Abaline O", 35, 3155.00)
			   );
		
		empList.forEach(System.out::println);
		
		System.out.println("-------------\n");
		
		empList.stream().sorted((e1,e2) -> {
			return (e1.getEmployeeAge().compareTo(e2.getEmployeeAge())); 
		}).forEach(System.out::println);
		
		System.out.println("-------------\n");
		
		empList.forEach(System.out::println);
	}

}
