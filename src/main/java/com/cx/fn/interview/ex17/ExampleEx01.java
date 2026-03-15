package com.cx.fn.interview.ex17;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.cx.fn.map.ex02.EmployeeVO;

public class ExampleEx01 {

	public static void main(String[] args) {
		try {
			List<EmployeeVO> empList = Arrays.asList(
						new EmployeeVO(12, "Rock", "Plumbing"),
						new EmployeeVO(13, "Tom", "Finance"),
						new EmployeeVO(14, "Sam", "HR"),
						new EmployeeVO(12, "Rock", "Sanitation"),
						new EmployeeVO(13, "Tom", "Transport")
					);
			
			empList.stream().collect(Collectors.groupingBy((employee) ->{
				return employee;
			}))
			.entrySet()
			.stream()
			.filter((entryObj) -> {
				return entryObj.getValue().size() > 1;
			}).map((entryObj) -> {
				return entryObj.getKey();
			}).forEach((emp) -> {
				System.out.println(emp);
			});
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
