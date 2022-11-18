package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.GPMDao;
import com.masai.Dao.GPMDaoImpl;
import com.masai.Model.EmployeeTotalWorkingDays;

public class ViewEmployeeWorkingDetails {

public static EmployeeTotalWorkingDays  EmployeeTotalWorkDetails(){
		
        Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the Employee ID ");
		int eid= sc.nextInt();

		System.out.println("Enter the Employee Name ");
		String eid1= sc.next();
		
		System.out.println("Enter the Employee Absent Days");
		int absent= sc.nextInt();
		
		GPMDao dao = new GPMDaoImpl();
		
//		EmployeeTotalWorkingDays eTWD = dao.viewTotalNumberOfWorkingdays(eid,eid1,absent);
//		return eTWD;


		EmployeeTotalWorkingDays eTWD = dao.viewTotalNumberOfWorkingdays(eid,eid1,absent);
		return eTWD;
		
	}
	
}
