package com.masai.frontend;

import java.util.Scanner;

import com.masai.beam.BDO;
import com.masai.deo.BDO_DaoImpl;
import com.masai.deo.BDO_Deo;
import com.masai.exceptions.BDOException;

public class MrnregaApp {

	public static void selectoption() {
		// TODO Auto-generated method stub
		
		BDO_Deo bdodeo = new BDO_DaoImpl();
		try {
			System.out.println("\nPlease select an option to continue");
			System.out.println("\n1. Login vai BDO");
			
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter Username");
				String uname = sc.next();
				
				System.out.println("Enter password");
				String pass = sc.next();
				
				
				
				try {
					BDO bdo = bdodeo.loginBDO(uname, pass);
					
					System.out.println("Login Succesfully......");
					MrnregaApp.selectoption();
					}
					catch(BDOException bd) {
						System.out.println(bd.getMessage());
					}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			MrnregaApp.selectoption();
		}
	}

}
