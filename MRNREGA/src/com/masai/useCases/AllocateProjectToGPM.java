package com.masai.useCases;

import java.util.Scanner;

import com.masai.Dao.BDODao;
import com.masai.Dao.BDODaoImpl;
import com.masai.exceptions.GPMException;
import com.masai.exceptions.ProjectException;

public class AllocateProjectToGPM {

public static String projectToGPM() throws GPMException, ProjectException {
        
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the GPM ID ");
		int gid= sc.nextInt();

		System.out.println("Enter the GPM Name ");
		String gn= sc.next();			
		
		System.out.println("Enter the Project ID");
		int pid= sc.nextInt();
		
		System.out.println("Enter the Project Name ");
		String pn= sc.next();
		
		
		BDODao dao = new BDODaoImpl();
		
//		try {
		String result = dao.allocateGpmInsideProject(gid, gn, pid, pn);
		
//		System.out.println(result);
//		}catch(Exception e) {
			
//			System.out.println(e.getMessage());
			
//		}
		
		return result;
	}
	
}
