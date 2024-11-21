package com.cx.fn.filter.ex08;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.cx.vo.EmployeeVO;

public class FilteringQuestionEx08Main {
	
	private static BiFunction<List<EmployeeVO>, Predicate<EmployeeVO>, Set<Map.Entry<String, Integer>>>  getEmployeeNameMap(){
		
		BiFunction<List<EmployeeVO>, Predicate<EmployeeVO>, Set<Map.Entry<String, Integer>>> fn = (list,predicateObj) -> {
			final Map<String, Integer> map = new HashMap<String, Integer>();
			list.stream().filter(predicateObj).forEach((emp) -> map.put(emp.getEmployeeName(), emp.getEmployeeAge()));			
			return map.entrySet();
		};
		
		return fn;
	}
	
	public static void main(String [] args) {
		try {
			List<EmployeeVO> empList =  Arrays.<EmployeeVO>asList(	
					new EmployeeVO(12, "Samatha N", 23, 3455.00),
					new EmployeeVO(32, "Alex P", 43, 5655.00),
					new EmployeeVO(2, "Usman B", 27, 1755.00),
					new EmployeeVO(21, "Abaline O", 35, 8155.00),
					new EmployeeVO(24, "Igor V", 45, 6712.6),
					new EmployeeVO(18, "Patric H", 38, 4821.6)
				);
			
			
			FilteringQuestionEx08Main.getEmployeeNameMap().apply(empList, (vo -> vo.getSalary() > 5000)).forEach((entry) -> System.out.println(entry.getKey()+" "+entry.getValue()));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
