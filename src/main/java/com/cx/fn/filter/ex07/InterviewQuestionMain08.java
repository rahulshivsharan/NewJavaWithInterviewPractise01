package com.cx.fn.filter.ex07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.cx.vo.DepartmentVO;
import com.cx.vo.EmployeeVO;

/**
 * For list of employees, filter those
 * employees who are having salary more than 35000 and
 * sort the filtered employees by desceding order of age.
 */
public class InterviewQuestionMain08 {

	public static void main(String[] args) {
		try {
			List<EmployeeVO> empList = Arrays.<EmployeeVO>asList(
					new EmployeeVO(121, "Sam Niel", 		34, 45000.00, new DepartmentVO(12, "Marketing")),
					new EmployeeVO(122, "Henry Patterson", 	51, 63000.00, new DepartmentVO(11, "Technology")),
					new EmployeeVO(127, "Kevin Oliver", 	41, 27000.00, new DepartmentVO(10, "HR")),
					new EmployeeVO(142, "Jim Carry", 		23, 15000.00, new DepartmentVO(16, "Finance")),
					new EmployeeVO(153, "Jim Murry", 		33, 47000.00, new DepartmentVO(11, "Technology")),
					new EmployeeVO(128, "Petre Thiel", 		54, 67000.00, new DepartmentVO(16, "Finance")),
					new EmployeeVO(141, "Jack Nicholson", 	47, 17000.00, new DepartmentVO(12, "Marketing")),
					new EmployeeVO(157, "Samuel Jackson", 	32, 34000.00, new DepartmentVO(11, "Technology")),
					new EmployeeVO(111, "Tim Johns", 		48, 12000.00, new DepartmentVO(10, "HR"))
				);
			
			List<EmployeeVO> filteredEmployeeList =  empList.stream().filter((employeeVo) -> {
															return employeeVo.getSalary() >= 35000;
														}).collect(Collectors.toList()).stream().sorted((employee1, employee2) -> {
															return employee2.getEmployeeAge().compareTo(employee1.getEmployeeAge());
														}).collect(Collectors.toList());
			
			filteredEmployeeList.forEach((vo) -> {
				System.out.println(vo);
			});
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
