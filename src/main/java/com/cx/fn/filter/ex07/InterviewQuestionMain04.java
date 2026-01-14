package com.cx.fn.filter.ex07;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.cx.vo.DepartmentVO;
import com.cx.vo.EmployeeVO;

/**
 * For given list of employees, give an output of total number of employees grouped by department it belongs to.
 * The output should be key-value pair where key is department and value is total number of employees
 * The key-value should be sorted occording to key which is department sorted order. 
 */
public class InterviewQuestionMain04 {

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
			
			Comparator<Map.Entry<String, List<EmployeeVO>>> comparatorFn = new Comparator<Map.Entry<String,List<EmployeeVO>>>() {
				
				@Override
				public int compare(Entry<String, List<EmployeeVO>> entry1, Entry<String, List<EmployeeVO>> entry2) {
					String departmentName1 = entry1.getKey();
					String departmentName2 = entry2.getKey();
					return departmentName1.compareTo(departmentName2);
				}
			};
			
			Set<Map.Entry<String, List<EmployeeVO>>> entrySet = empList.stream()
																		.collect(Collectors.groupingBy(groupByDept))
																		.entrySet()
																		.stream()
																		.sorted(comparatorFn)
																		.collect(Collectors.toCollection(LinkedHashSet::new));
			
			entrySet.forEach((entryObj) -> {
				String deptName = entryObj.getKey();
				List<EmployeeVO> employeeList = entryObj.getValue();
						
				System.out.println("Department \""+deptName+"\" have \""+employeeList.size()+"\" number of employees");
			});			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
