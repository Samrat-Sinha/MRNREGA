package com.masai.useCases;

import java.util.Scanner;

import com.masai.Dao.BDODao;
import com.masai.Dao.BDODaoImpl;
import com.masai.Model.BDO;

public class RegisterBDO {

public static String RegisterAsBDO() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter BDO Name ");
		String bdoname = sc.next();
		
		System.out.println("Enter BDO email ");
		String bdoeml = sc.next();
		
		System.out.println("Enter BDO password ");
		String bdopswd = sc.next();
		
		BDODao dao = new BDODaoImpl();
		BDO bdo = new BDO();
		
		bdo.setName(bdoname);
		bdo.setEmail(bdoeml);
		bdo.setPassword(bdopswd);
				
		String result = dao.registerAsBDO(bdo);
		return result;
	}
	
}
