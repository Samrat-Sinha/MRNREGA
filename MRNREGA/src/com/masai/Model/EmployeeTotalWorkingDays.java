package com.masai.Model;

public class EmployeeTotalWorkingDays {

	private int employeeId;
	private String employeeName;
	private String employeeSkill;
	private String projectName;
	private int assignDays;
	private int noOfAbsentDays;
	private int noOfWorkingDays;
	private int wages;
	
	public EmployeeTotalWorkingDays() {
		// TODO Auto-generated constructor stub
	}

	

	



	public EmployeeTotalWorkingDays(int employeeId, String employeeName, String employeeSkill, String projectName,
			int assignDays, int noOfAbsentDays, int noOfWorkingDays, int wages) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSkill = employeeSkill;
		this.projectName = projectName;
		this.assignDays = assignDays;
		this.noOfAbsentDays = noOfAbsentDays;
		this.noOfWorkingDays = noOfWorkingDays;
		this.wages = wages;
	}







	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeSkill() {
		return employeeSkill;
	}

	public void setEmployeeSkill(String employeeSkill) {
		this.employeeSkill = employeeSkill;
	}

	public int getNoOfWorkingDays() {
		return noOfWorkingDays;
	}

	public void setNoOfWorkingDays(int noOfWorkingDays) {
		this.noOfWorkingDays = noOfWorkingDays;
	}

	public int getWages() {
		return wages;
	}

	public void setWages(int wages) {
		this.wages = wages;
	}



	public int getAssignDays() {
		return assignDays;
	}



	public void setAssignDays(int assignDays) {
		this.assignDays = assignDays;
	}



	public int getNoOfAbsentDays() {
		return noOfAbsentDays;
	}



	public void setNoOfAbsentDays(int noOfAbsentDays) {
		this.noOfAbsentDays = noOfAbsentDays;
	}







	public String getProjectName() {
		return projectName;
	}







	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}







	@Override
	public String toString() {
		return "EmployeeTotalWorkingDays [employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", employeeSkill=" + employeeSkill + ", projectName=" + projectName + ", assignDays=" + assignDays
				+ ", noOfAbsentDays=" + noOfAbsentDays + ", noOfWorkingDays=" + noOfWorkingDays + ", wages=" + wages
				+ "]";
	}



	
	
}
