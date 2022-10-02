package com.masai.usecases;

import java.util.Scanner;

import com.masai.beam.BDO;
import com.masai.deo.BDO_DaoImpl;
import com.masai.deo.BDO_Deo;
import com.masai.exceptions.BDOException;

public class BDOLoginUseCase {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username");
		String uname = sc.next();
		

		
		System.out.println("Enter password");
		String pass = sc.next();
		
		BDO_Deo bdodeo = new BDO_DaoImpl();
		
		try {
		BDO bdo = bdodeo.loginBDO(uname, pass);
		
		System.out.println("Login Succesfully......");
		}
		catch(BDOException bd) {
			System.out.println(bd.getMessage());
		}
		
		
		
		
		
	}
}
