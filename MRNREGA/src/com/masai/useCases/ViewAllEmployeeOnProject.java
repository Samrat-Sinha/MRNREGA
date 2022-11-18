package com.masai.useCases;

import java.util.List;

import com.masai.Dao.GPMDao;
import com.masai.Dao.GPMDaoImpl;
import com.masai.Model.EmployeeTotalWorkingDays;
import com.masai.exceptions.EmployeeException;

public class ViewAllEmployeeOnProject {

public static List<EmployeeTotalWorkingDays> getallworkdata() throws EmployeeException {
		
		GPMDao dao = new GPMDaoImpl();
		
		List<EmployeeTotalWorkingDays> allemp = dao.getAllEmployeeOfProject();
		
		return allemp;
		
		
//        System.out.println("Total Employee Details working on project :");
//        System.out.println();
//	    	allemp.forEach(eTWD->{
//			System.out.println("Employee Id                  : "+ eTWD.getEmployeeId());
//			System.out.println("Employee Name                : "+eTWD.getEmployeeName());
//			System.out.println("Employee Skill               : "+eTWD.getEmployeeSkill());
//			System.out.println("Employee Project Name        : " +eTWD.getProjectName());
//			System.out.println("Employee Assign Working Days : "+eTWD.getAssignDays());
//			System.out.println("Employee Absent Days         : "+eTWD.getNoOfAbsentDays());
//			System.out.println("Employee Total Working Days  : "+eTWD.getNoOfWorkingDays());
//			System.out.println("Employee Total Wages         : "+eTWD.getWages());
//		    System.out.println();
//		    System.out.println("===============================================");
//		    System.out.println();
//					});
		
	}
	
}
