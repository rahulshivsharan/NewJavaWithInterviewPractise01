package com.cx.vo;

import java.io.Serializable;

public class EmployeeVO implements Serializable{
	private Integer employeeId;
	private String employeeName;
	private Integer employeeAge;
	private Double salary;
	
	public EmployeeVO() {}
	
	public EmployeeVO(Integer id, String name, Integer age, Double salary) {
		this.employeeId = id;
		this.employeeName = name;
		this.employeeAge = age;
		this.salary = salary;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(Integer employeeAge) {
		this.employeeAge = employeeAge;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		StringBuffer strb = new StringBuffer();
		strb.append("Employee ID \"").append(this.employeeId)
			.append("\", name \"").append(this.employeeName)
			.append("\", age \"").append(this.employeeAge)
			.append("\", salary \"").append(this.salary)
			.append("\n");
		
		return strb.toString();
	}
}
