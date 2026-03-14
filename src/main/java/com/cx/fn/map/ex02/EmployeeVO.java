package com.cx.fn.map.ex02;

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
		return this.id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof EmployeeVO) {
			EmployeeVO vo = (EmployeeVO) obj;
			if(this.id == vo.getId() && this.name.equals(vo.getName())) {
				return true;
			}
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
