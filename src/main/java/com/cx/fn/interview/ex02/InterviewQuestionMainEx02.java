package com.cx.fn.interview.ex02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cx.vo.DepartmentVO;
import com.cx.vo.EmployeeVO;

/**
 * The below code is demonstration of Employees in department
 * Getting Employee from each department having max salary
 */
public class InterviewQuestionMainEx02 {

	
	public static void main(String[] args) {
		List<EmployeeVO> employeesList = null;
		try {
			employeesList = Arrays.<EmployeeVO>asList(
						new EmployeeVO(123, "Igor Stonkovic", 23, 5367.00, new DepartmentVO(23, "IT")),
						new EmployeeVO(124, "Adam Sandler", 35, 6567.00, new DepartmentVO(23, "IT")),
						new EmployeeVO(125, "Jayco Jamti", 55, 7567.00, new DepartmentVO(43, "Marketing")),
						new EmployeeVO(126, "Almorda Tigros", 37, 8567.00, new DepartmentVO(46, "HR")),
						new EmployeeVO(127, "Simon Goback", 43, 3667.00, new DepartmentVO(23, "IT")),
						new EmployeeVO(128, "Victor Kalmi", 47, 9667.00, new DepartmentVO(43, "Marketing"))
					);
			
			Map<DepartmentVO, Optional<EmployeeVO>> map = employeesList.stream().collect(Collectors.groupingBy(EmployeeVO::getDepartment, 
																 						Collectors.maxBy(Comparator.comparingDouble(EmployeeVO::getSalary))));
			
			map.forEach((dept, empOpt) -> {
				empOpt.ifPresent((employee) -> {
					System.out.println("\""+dept.getDepartmentName()+"\" having employee \""+employee.getEmployeeName()+"\" with salary "+employee.getSalary());	
				});
			});
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
