package com.cx.fn.filter.ex07;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.cx.vo.DepartmentVO;
import com.cx.vo.EmployeeVO;

/**
 * The below code takes list of employees
 * and output the map where the employees are grouped by department to which the employee 
 * belong to. It prints the key-value pair where the key is department name and value is the total
 * number of employees working in that department
 */
public class InterviewQuestionMain03 {

	public static void main(String[] args) {
		try {
			List<EmployeeVO> empList = Arrays.<EmployeeVO>asList(
					new EmployeeVO(121, "Sam Niel", 		34, 45000.00, new DepartmentVO(12, "Marketing")),
					new EmployeeVO(142, "Jim Carry", 		23, 15000.00, new DepartmentVO(16, "Finance")),
					new EmployeeVO(121, "Petre Thiel", 		54, 67000.00, new DepartmentVO(16, "Finance")),
					new EmployeeVO(121, "Jack Nicholson", 	47, 17000.00, new DepartmentVO(12, "Marketing")),
					new EmployeeVO(121, "Samuel Jackson", 	32, 34000.00, new DepartmentVO(11, "Technology")),
					new EmployeeVO(121, "Tim Johns", 		48, 12000.00, new DepartmentVO(10, "HR"))
				);
			
			Function<EmployeeVO, String> groupByDept = new Function<EmployeeVO, String>() {
				
				@Override
				public String apply(EmployeeVO empVO) {
					return empVO.getDepartment().getDepartmentName();
				}
			};
			
			Map<String, List<EmployeeVO>> groupByDeptMap = empList.stream().collect(Collectors.groupingBy(groupByDept));
			
			groupByDeptMap.forEach((deptName, employees) -> {
				System.out.println("Department \""+deptName+"\" have \""+employees.size()+"\" number of employees");
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
