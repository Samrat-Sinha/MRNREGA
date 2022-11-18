package com.masai.Dao;


import java.util.List;

import com.masai.Model.BDO;
import com.masai.Model.Employee;
import com.masai.Model.GPM;
import com.masai.Model.Project;
import com.masai.exceptions.BDOException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.GPMException;

public interface BDODao {
	
	public BDO loginBDO(String username,String password)throws BDOException;
   
	public String CreateProject(Project project);
	
	public List<Project> getAllProjectDetails()throws BDOException;
	
	public String CreateGPM(GPM gpm);
	
	public List<GPM> getAllGpmDetails()throws BDOException;
	
	public String AlocateGpmtoProject(int gpmId,int projectId)throws BDOException,GPMException;
	
	public GPM loginGpm(String gpmusername , String password)throws GPMException;
	
	public String CreateEmployee(Employee employee);

	public List<Employee> getAllEmpDetails()throws EmployeeException;
	
	public String AlocateEmptoProject(int empId,int projectId)throws BDOException,EmployeeException;
}
