package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.BDODao;
import com.masai.Dao.BDODaoImpl;
import com.masai.Model.Project;

public class ProjectCreatedByBDO {

	public static String ProjectCreate() {
		
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Project Name ");
		String pname = sc.next();
		
		System.out.println("Enter Project Work ");
		String pwork = sc.next();
		
		System.out.println("Enter Project Location ");
		String ploc = sc.next();
		
		BDODao dao = new BDODaoImpl();
		Project project = new Project();
		
		project.setProjectName(pname);
		project.setProjectWorkDetail(pwork);
		project.setProjectWorkLocation(ploc);
						
		String result = dao.createProject(project);
//		System.out.println(result);
		return result;
	
}
	
}
