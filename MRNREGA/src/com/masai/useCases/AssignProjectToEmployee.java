package com.masai.useCases;

import java.util.Scanner;

import com.masai.Dao.GPMDao;
import com.masai.Dao.GPMDaoImpl;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.ProjectException;

public class AssignProjectToEmployee {

public static String AssignEmp() {
        
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the Employee ID ");
		int eid= sc.nextInt();

		System.out.println("Enter the Employee Name ");
		String en= sc.next();			
		
		System.out.println("Enter the Project ID");
		int pid= sc.nextInt();
		
		System.out.println("Enter the Project Name ");
		String pn= sc.next();
		
		System.out.println("Enter Assign of Days");
		int days = sc.nextInt();
		
		GPMDao dao = new GPMDaoImpl();
		
//		try {
		String result="";
		try {
			result = dao.allocateEmployeeInsideProject(eid, en, pid, pn,days);
		} catch (EmployeeException e) {
			e.printStackTrace();
		} catch (ProjectException e) {
			e.printStackTrace();
		}
		

		return result;
//		}catch(Exception e) {
//			
//			System.out.println(e.getMessage());
//			
//		}
	}
	
}
