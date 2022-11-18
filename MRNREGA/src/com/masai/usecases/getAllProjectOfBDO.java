package com.masai.usecases;

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
////			System.out.println(allprojs);
////			allprojs.forEach(p->{
////			    System.out.println("Product Id       : " + p.getProjectId());
////			    System.out.println("Product Name     : " + p.getProjectName());
////			    System.out.println("Product Work     : " + p.getProjectWorkDetail());
////			    System.out.println("Product LOcation : " + p.getProjectWorkLocation());
////			    System.out.println();
////			    System.out.println("===============================================");
////			});
//		} catch (BDOException e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
//		return allprojs;
		
		
		
		
	}
	
}
