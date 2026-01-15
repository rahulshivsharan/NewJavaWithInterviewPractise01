package com.cx.fn.filter.ex07;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.cx.vo.DepartmentVO;
import com.cx.vo.EmployeeVO;

/**
 * Filter list of employees whose salary is more than 35000 and 
 * output map where key is employee name and value is employee age
 */
public class InterviewQuestionMain06 {

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
			
			Predicate<EmployeeVO> filterEmployees = new Predicate<EmployeeVO>() {
				
				@Override
				public boolean test(EmployeeVO vo) {					
					return vo.getSalary() >= 35000 ? true : false;
				}
			};
			
			 Map<String, Integer> map = empList.stream().filter(filterEmployees).collect(Collectors.toMap(EmployeeVO::getEmployeeName, EmployeeVO::getEmployeeAge));
			 
			 map.forEach((employeeName, employeeAge) -> {
				 System.out.println("Employee \""+employeeName+"\" is \""+employeeAge+"\" years old");
			 });
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
