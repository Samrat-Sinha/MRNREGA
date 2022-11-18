package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.GPMDao;
import com.masai.Dao.GPMDaoImpl;
import com.masai.Model.Employee;
import com.masai.exceptions.EmployeeException;

public class CreatingEmployeeByGPM {

public static String creatingemployee() throws EmployeeException {
		
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Name ");
		String emplname = sc.next();
		
		System.out.println("Enter Employee Skill ");
		String empskl = sc.next();
		
		System.out.println("Enter Employee Wages ");
		int emplwages = sc.nextInt();
				
		GPMDao dao = new GPMDaoImpl();
		Employee employee = new Employee();
		
		employee.setName(emplname);
		employee.setSkill(empskl);
		employee.setWages(emplwages);
				
		String result = dao.createEmployee(employee);
//		System.out.println(result);
		return result;
		
		
	}
	
}
