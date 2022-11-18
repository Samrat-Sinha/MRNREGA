package com.masai.useCases;

import java.util.List;

import com.masai.Dao.GPMDao;
import com.masai.Dao.GPMDaoImpl;
import com.masai.Model.Employee;

public class getAllEmployee {

public static List<Employee> viewAllEmp() {
		
		GPMDao dao = new GPMDaoImpl();
		
		List<Employee> allemp = dao.getAllEmployee();

		return allemp;	
	}
}
