package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.BDODao;
import com.masai.Dao.BDODaoImpl;

public class LoginBDO {

public static String loginAsBDO() {
		
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter BDO email ");
		String bdoeml = sc.next();
		
		System.out.println("Enter BDO password ");
		String bdopswd = sc.next();
		
		BDODao dao = new BDODaoImpl();
						
		String result = dao.loginAsBDO(bdoeml, bdopswd);
//		System.out.println(result);
		return result;
		
	}
	
}
