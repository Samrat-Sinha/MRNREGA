package com.masai.Model;

public class Employee {

	private int empId;
	private String empName;
	private String address;
	
	 
	
	public Employee() {
		super();
	}
	
	public Employee(int empId, String empName, String address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.address = address;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + "]";
	}
   
	
	
	
}
