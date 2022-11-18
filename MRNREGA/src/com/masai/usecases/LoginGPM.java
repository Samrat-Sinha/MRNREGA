package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.GPMDao;
import com.masai.Dao.GPMDaoImpl;
import com.masai.exceptions.GPMException;

public class LoginGPM {

public static String loginAsGpm() throws GPMException {
		
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter GPM email ");
		String gpmeml = sc.next();
		
		System.out.println("Enter GPM password ");
		String gpmpswd = sc.next();
		
		GPMDao dao = new GPMDaoImpl();
						
		String result = dao.loginAsGPM(gpmeml, gpmpswd);
//		System.out.println(result);
		return result;
		
	}
	
}
