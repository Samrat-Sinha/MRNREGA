package com.masai.useCases;

import java.util.Scanner;

import com.masai.Dao.BDODao;
import com.masai.Dao.BDODaoImpl;
import com.masai.Model.GPM;

public class CreatingGPM {

public static String creategpmbybdo() {
		
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter GPM Name ");
		String gpmname = sc.next();
		
		System.out.println("Enter GPM Address ");
		String gpmadd = sc.next();
		
		System.out.println("Enter GPM Email ");
		String gpmeml = sc.next();
		
		System.out.println("Enter GPM password ");
		String gpmpswd = sc.next();
		
		BDODao dao = new BDODaoImpl();
		GPM gpm = new GPM();
		
		gpm.setGpmName(gpmname);
		gpm.setGpmAddress(gpmadd);
		gpm.setGpmEmail(gpmeml);
		gpm.setGpmpassword(gpmpswd);
				
		String result = dao.registerGPMbyBDO(gpm);
//		System.out.println(result);
		return result;
				
		
	}
	
}
