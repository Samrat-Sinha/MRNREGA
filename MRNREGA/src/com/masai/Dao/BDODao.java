package com.masai.Dao;


import java.util.List;

import com.masai.Model.BDO;
import com.masai.Model.Employee;
import com.masai.Model.GPM;
import com.masai.Model.Project;
import com.masai.exceptions.BDOException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.GPMException;
import com.masai.exceptions.ProjectException;

public interface BDODao {
	
public String registerAsBDO(BDO bdo);
	
	public String loginAsBDO(String email,String password);
	
	public String createProject(Project project);
	
	public List<Project> getAllProject()throws BDOException;
	
	public String registerGPMbyBDO(GPM gpm);
	
	public List<GPM> getAllGPM();
	
	public String allocateGpmInsideProject(int gpmId,String gpmName,int projectId,String projectName)throws GPMException,ProjectException;
}
