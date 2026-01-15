package com.cx.fn.filter.ex07;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.cx.vo.DepartmentVO;
import com.cx.vo.EmployeeVO;

/**
 * For the list of employees filter those employees whose salary is greated then 35000
 * and give output of Key-Value pair where key is employee name and value is emlpoyee age 
 * arranged in reducing order of employee age
 */
public class InterviewQuestionMain07 {

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
			
			Set<Map.Entry<String, Integer>> setOfEmp =	empList.stream().filter((employeeVO) -> {
															return employeeVO.getSalary() > 35000;
														}).collect(Collectors.toMap(EmployeeVO::getEmployeeName, EmployeeVO::getEmployeeAge))
														.entrySet().stream().sorted((entry1, entry2) -> {
															Integer employeeAge1 = entry1.getValue();
															Integer employeeAge2 = entry2.getValue();
															return  employeeAge2.compareTo(employeeAge1);
														}).collect(Collectors.toCollection(LinkedHashSet::new));
			
			setOfEmp.forEach((entryObj) -> {
				String employeeName = entryObj.getKey();
				Integer employeeAge = entryObj.getValue();
				System.out.println("\""+employeeName+"\" is \""+employeeAge+"\" years old");
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
