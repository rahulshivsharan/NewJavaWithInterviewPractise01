package com.cx.fn.interview.ex17;

import java.util.Objects;


public class EmployeeVO {
	private Integer id;
	private String name;
	private String department;
	
	public EmployeeVO(Integer id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof EmployeeVO)) {
			return false;
		}
		
		EmployeeVO vo = (EmployeeVO) obj;
		if (Objects.equals(this.id, vo.getId()) && Objects.equals(this.name, vo.getName())) {
			return true;
		}		
		
		return false;
	}
	
	@Override
	public String toString() {
		StringBuffer strb = new StringBuffer();
		strb.append("ID : ").append(this.getId())
			.append(", NAME : ").append(this.getName())
			.append(", DEPARTMENT : ").append(this.getDepartment());
		return strb.toString();
	}
}

