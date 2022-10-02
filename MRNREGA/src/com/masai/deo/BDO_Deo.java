package com.masai.deo;


import java.util.List;

import com.masai.beam.BDO;
import com.masai.beam.Employee;
import com.masai.beam.GPM;
import com.masai.beam.Project;
import com.masai.exceptions.BDOException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.GPMException;

public interface BDO_Deo {
	
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
