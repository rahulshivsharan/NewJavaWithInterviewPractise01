package com.cx.vo;

import java.io.Serializable;

public class DepartmentVO implements Serializable{
	private String departmentName;
	private Integer departmentNo;
	
	public DepartmentVO(Integer deptNo, String deptName) {
		this.departmentNo = deptNo;
		this.departmentName = deptName;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public Integer getDepartmentNo() {
		return departmentNo;
	}
	
	public void setDepartmentNo(Integer departmentNo) {
		this.departmentNo = departmentNo;
	}
	
	@Override
	public boolean equals(Object o) {
		DepartmentVO vo = (DepartmentVO) o;
		return (vo.getDepartmentNo() == this.departmentNo);
	}
	
	@Override
	public int hashCode() {
		return this.departmentNo;
	}

	@Override
	public String toString() {
		StringBuffer strb = new StringBuffer();
		strb.append("Department Name ").append(this.getDepartmentName());
		return strb.toString();
	}
}
