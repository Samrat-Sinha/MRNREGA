package com.masai.deo;


import java.util.List;

import com.masai.beam.BDO;
import com.masai.beam.GPM;
import com.masai.beam.Project;
import com.masai.exceptions.BDOException;

public interface BDO_Deo {
	
	public BDO loginBDO(String username,String password)throws BDOException;
   
	public String CreateProject(Project project);
	
	public List<Project> getAllProjectDetails()throws BDOException;
	
	public String CreateGPM(GPM gpm);
	
	public List<GPM> getAllGpmDetails()throws BDOException;
	
}
