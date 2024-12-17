package com.cx.fn.interview.ex03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cx.vo.EmployeeVO;



/**
 * Map containing Key as department name and value as List of Employees beloing to that department
 * 
 * Get a Map where Key will be department name and value will be an employee with highest salary. 
 */
public class InterviewExMain03 {

	public static void main(String[] args) {
		Map<String, List<EmployeeVO>> empMap = null; 
		try {
			empMap = new HashMap<String, List<EmployeeVO>>();
			
			empMap.put("HR", Arrays.asList(	new EmployeeVO(101, "Dipender Goyal", 24, 4534.00), 
											new EmployeeVO(106, "Subhash Naidu", 27, 1404.00)
					));
			
			
			empMap.put("Finance", Arrays.asList(
									new EmployeeVO(113, "Swaransh Bharti", 43, 1304.00),
									new EmployeeVO(118, "Venkatesh Kalgallu", 45, 1604.00),
									new EmployeeVO(128, "Adinath Chaudhary", 47, 5621.89)
					));
			
			
			empMap.put("IT", Arrays.asList(
									new EmployeeVO(116, "Kaustubh Kale", 57, 5604.00),
									new EmployeeVO(136, "Rakshit Jadhav", 33, 9604.00)
				));
			
			
			
			empMap.put("Marketing", Arrays.asList(
									new EmployeeVO(115, "Pranav Ombale", 41, 3604.00), 
									new EmployeeVO(117, "Ishwar Godbole", 39, 2515.00)
				));

			
			
			
			Map<String, EmployeeVO> map = empMap.entrySet().stream().collect(Collectors.toMap(	Map.Entry::getKey, 
																								(entry) ->  entry.getValue().stream().max(Comparator.comparingDouble(EmployeeVO::getSalary)).orElse(null)
																			));
			
			map.forEach((department, employee) -> {
				System.out.println(department+" having employee "+employee);
			});
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
