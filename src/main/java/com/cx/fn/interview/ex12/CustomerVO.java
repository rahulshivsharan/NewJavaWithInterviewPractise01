package com.cx.fn.interview.ex12;

import java.util.Objects;

public class CustomerVO {
	private String name;
	private Integer id;
	private String address;
	
	public CustomerVO(Integer id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		
		if(obj == null || getClass() != obj.getClass())
			return false;
		
		CustomerVO that = (CustomerVO) obj;		
		return Objects.equals(this.getId(), that.getId());
	}
	
	@Override
	public String toString() {
		StringBuffer strb = new StringBuffer();
		strb.append("Customer Id \"").append(this.getId()).append("\", ")
			.append("Customer name \"").append(this.getName()).append("\", ")
			.append("Customer address \"").append(this.getAddress()).append("\", \n");
		
		return strb.toString();
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}	
	
}
