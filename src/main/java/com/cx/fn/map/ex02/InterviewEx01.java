package com.cx.fn.map.ex02;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class InterviewEx01 {

	public static void main(String[] args) {
		try {
			List<EmployeeVO> empList = Arrays.asList(
						new EmployeeVO(12, "Rock", "Plumbing"),
						new EmployeeVO(13, "Tom", "Finance"),
						new EmployeeVO(14, "Sam", "HR"),
						new EmployeeVO(12, "Rock", "Sanitation"),
						new EmployeeVO(13, "Tom", "Transport")
					);
			
			Map<EmployeeVO, List<EmployeeVO>> empMap = empList.stream().collect(Collectors.groupingBy((employee) -> employee));
			System.out.println(empMap);
			System.out.println("\n\n\n");
			Set<Map.Entry<EmployeeVO, List<EmployeeVO>>> set = empMap.entrySet().stream().filter((entryObj -> {
				return entryObj.getValue().size() > 1;
			})).collect(Collectors.toSet());
			
			set.forEach((entryObj) -> {
				System.out.println(entryObj.getKey());
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
