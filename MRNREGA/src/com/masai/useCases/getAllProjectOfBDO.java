package com.masai.useCases;

import java.util.List;

import com.masai.Dao.BDODao;
import com.masai.Dao.BDODaoImpl;
import com.masai.Model.Project;
import com.masai.exceptions.BDOException;

public class getAllProjectOfBDO {

public static List<Project> allProject() throws BDOException {
		
		BDODao dao = new BDODaoImpl();
		List<Project> allproj = dao.getAllProject();
		return allproj;
//		try {
//			

		
		
		
		
	}
	
}
