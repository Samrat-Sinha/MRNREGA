package com.masai.frontend;

import java.util.List;
import java.util.Scanner;

import com.masai.beam.BDO;
import com.masai.beam.GPM;
import com.masai.beam.Project;
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
					
					while(true) {
						System.out.println("\n1. Create a Project");
						System.out.println("\n2. View List Of Project.");
						System.out.println("\n3. Create new Gram Panchayat Member(GPM).");
						System.out.println("\n4. View all the Gram Panchayat Member(GPM).");
						System.out.println("\n5. Allocate  Project to Gram Panchayat Member(GPM).");
						System.out.println("\n6. See List of Employee working on that Project and their wages.");
						System.out.println("\n7. Exit");
						int bdon = sc.nextInt();
						if(bdon==1) {
						
							System.out.println("Enter Project Title : ");
							String prodesc = sc.next();
							
							System.out.println("Enter Project Destrict : ");
							String prodist = sc.next();
							
							System.out.println("Enter Project Village : ");
							String provill = sc.next();
							
							Project project = new Project();
							
							project.setProjectDesc(prodesc);
							project.setProjectDist(prodist);
							project.setProjectVillage(provill);
							
							String result = bdodeo.CreateProject(project);
							
							System.out.println(result);
							
						}
						if(bdon==2) {
							
							try {
								List<Project> projects = bdodeo.getAllProjectDetails();
								projects.forEach(s->System.out.println(s));
							}
							catch(BDOException bd) {
								System.out.println(bd.getMessage());
							}
							
						}
						if(bdon==3) {
							
							System.out.println("Enter GPM Name : ");
							String gpmname = sc.next();
							
							System.out.println("Enter GPM Village : ");
							String gpmvill = sc.next();
							
							System.out.println("Enter GPM email : ");
							String gpmeml = sc.next();
							
							System.out.println("Enter GPM Password : ");
							String gpmpsd = sc.next();
							
							
							GPM gpm = new GPM();
							
							gpm.setGpmName(gpmname);
							gpm.setGpmVillage(gpmvill);
							gpm.setGpmEmail(gpmeml);
							gpm.setGpmpassword(pass);
							
							String result = bdodeo.CreateGPM(gpm);
							
							System.out.println(result);
							
						}
						if(bdon==4) {
							
							try {
								List<GPM> gpms = bdodeo.getAllGpmDetails();
								gpms.forEach(s->System.out.println(s));
							}
							catch(BDOException bd) {
								System.out.println(bd.getMessage());
							}
							
						}
						if(bdon==5) {
							
						}
						if(bdon==6) {
							
						}
						if(bdon==7) {
							break;
						}
						
					}
					MrnregaApp.selectoption();
					}
					catch(BDOException bd) {
						System.out.println(bd.getMessage());
					}
				
			case 2:
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			MrnregaApp.selectoption();
		}
	}

}
