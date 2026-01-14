package com.cx.fn.filter.ex07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.cx.vo.DepartmentVO;
import com.cx.vo.EmployeeVO;


/**
 * For the given list of employees, get the output where the employees
 * are grouped by department and for every department the employees are sorted 
 * by salary.
 * So the output will be key as department Name and value as list of employees belonging to those
 * departments sorted by salary in descending order.
 */
public class InterviewQuestionMain05 {

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
			
			/**
			 * below function takes input as employee and outputs department of the employee 
			 */
			Function<EmployeeVO, String> groupByDept = new Function<EmployeeVO, String>() {
				
				@Override
				public String apply(EmployeeVO empVO) {
					return empVO.getDepartment().getDepartmentName();
				}
			};
			
			/**
			 * below is comparator where the compare method accepts two arguments of Map.Entry
			 * objects and compares key department name.
			 */
			Comparator<Map.Entry<String, List<EmployeeVO>>> comparatorFn = new Comparator<Map.Entry<String,List<EmployeeVO>>>() {
				
				@Override
				public int compare(Entry<String, List<EmployeeVO>> entry1, Entry<String, List<EmployeeVO>> entry2) {
					String departmentName1 = entry1.getKey();
					String departmentName2 = entry2.getKey();
					return departmentName1.compareTo(departmentName2);
				}
			};
			
			/**
			 * The below function accepts input argument as Map.Entry and outputs the list of
			 * employees sorted by their salary in descending order.
			 */
			Function<Map.Entry<String, List<EmployeeVO>>, List<EmployeeVO>> employeeEntryFn = new Function<Map.Entry<String, List<EmployeeVO>>, List<EmployeeVO>>() {

				@Override
				public List<EmployeeVO> apply(Entry<String, List<EmployeeVO>> entryObj) {
					List<EmployeeVO> empList = entryObj.getValue();
					List<EmployeeVO> sortedEmployeeList = empList.stream().sorted((emp1, emp2) -> {
																	return emp2.getSalary().compareTo(emp1.getSalary());
															}).collect(Collectors.toList());		
					
					return sortedEmployeeList;
				}
				
			}; 
			
			Map<String, List<EmployeeVO>> employeeMap = empList.stream().collect(Collectors.groupingBy(groupByDept))
																.entrySet().stream().sorted(comparatorFn)
																.collect(Collectors.toMap(Map.Entry::getKey, employeeEntryFn));
			
			employeeMap.forEach((deptName, employeeList) -> {
						
				System.out.println("Department \""+deptName+"\" have following employees");
				
				employeeList.forEach((vo) -> {
					System.out.println(vo);
				});
			});			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
