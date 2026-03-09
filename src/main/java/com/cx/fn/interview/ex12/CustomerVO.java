package com.cx.fn.interview.ex12;

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
		int code = this.id * 31;
		return code;
	}
	
	@Override
	public boolean equals(Object obj) {
		CustomerVO customer = (CustomerVO) obj;
		
		if(this.getId() == customer.getId()) {
			return true;
		}
		
		return false;
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
