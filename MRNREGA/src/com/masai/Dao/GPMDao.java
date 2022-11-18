package com.masai.Dao;

import java.util.List;

import com.masai.Model.Employee;
import com.masai.Model.EmployeeTotalWorkingDays;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.GPMException;
import com.masai.exceptions.ProjectException;

public interface GPMDao {

    public String loginAsGPM(String email,String password)throws GPMException;
	
	public String createEmployee(Employee employee)throws EmployeeException;
	
	public List<Employee> getAllEmployee();
	
	public String allocateEmployeeInsideProject(int empId,String name,int projectId,String projectName,int noOfWorkingDays)throws EmployeeException,ProjectException;
	
    public EmployeeTotalWorkingDays viewTotalNumberOfWorkingdays(int employeeId,String employeeName,int absentdays);

    public List<EmployeeTotalWorkingDays> getAllEmployeeOfProject()throws EmployeeException;
    
	
}
