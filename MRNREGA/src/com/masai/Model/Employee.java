package com.masai.Model;

public class Employee {


	private int empId;
	private String name;
	private String skill;
	private int wages;
	
	public Employee() {
		
	}

	

	public Employee(int empId, String name, String skill, int wages) {
		super();
		this.empId = empId;
		this.name = name;
		this.skill = skill;
		this.wages = wages;
	}



	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}



	public int getWages() {
		return wages;
	}



	public void setWages(int wages) {
		this.wages = wages;
	}



	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", skill=" + skill + ", wages=" + wages + "]";
	}

	

	
	
	
}
