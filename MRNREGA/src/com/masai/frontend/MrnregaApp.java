package com.masai.frontend;

import java.util.List;
import java.util.Scanner;

import com.masai.Model.BDO;
import com.masai.Model.Employee;
import com.masai.Model.GPM;
import com.masai.Model.Project;
import com.masai.deo.BDO_DaoImpl;
import com.masai.deo.BDO_Deo;
import com.masai.exceptions.BDOException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.GPMException;

public class MrnregaApp {

	public static void selectoption() {
		// TODO Auto-generated method stub
		
		BDO_Deo bdodeo = new BDO_DaoImpl();
		try {
			System.out.println("\nPlease select an option to continue");
			System.out.println("\n1. BDO Login");
			System.out.println("\n2. GPM Login ");
			System.out.println("\n3. Exit Mrnrega");
			System.out.println();
			
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
					 System.out.println();
					 System.out.println("======================================================================================");
					 System.out.println();
					
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
							System.out.println();
							System.out.println("======================================================================================");
						}
						if(bdon==2) {
							
							try {
								List<Project> projects = bdodeo.getAllProjectDetails();
								projects.forEach(s->System.out.println(s));
								System.out.println();
								System.out.println("======================================================================================");
								
							}
							catch(BDOException bd) {
								System.out.println(bd.getMessage());
								System.out.println();
								System.out.println("======================================================================================");
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
							gpm.setGpmpassword(gpmpsd);
							
							String result = bdodeo.CreateGPM(gpm);
							
							System.out.println(result);
							System.out.println();
							System.out.println("======================================================================================");
						}
						if(bdon==4) {
							
							try {
								List<GPM> gpms = bdodeo.getAllGpmDetails();
								gpms.forEach(s->System.out.println(s));
								System.out.println();
								System.out.println("======================================================================================");
							}
							catch(BDOException bd) {
								System.out.println(bd.getMessage());
								System.out.println();
								System.out.println("======================================================================================");
							}
							
						}
						if(bdon==5) {
							
							System.out.println("Enter the gpmId");
							int gpmId = sc.nextInt();
							
							System.out.println("Enter the projectId");
							int projId = sc.nextInt();
							
							try {
								String result = bdodeo.AlocateGpmtoProject(gpmId, projId);
										System.out.println(result);
										System.out.println();
										System.out.println("======================================================================================");
							} catch (Exception e) {
								// TODO Auto-generated catch block
							   System.out.println(e.getMessage());
							   System.out.println();
							   System.out.println("======================================================================================");
							}
							
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
						 System.out.println();
						   System.out.println("======================================================================================");
					}
				
			case 2: 
				
				System.out.println("Enter Username");
				String gpmuname = sc.next();
				

				
				System.out.println("Enter password");
				String gpmpass = sc.next();
				
							
				try {
				GPM gpm = bdodeo.loginGpm(gpmuname, gpmpass);
				
				System.out.println("Login Sucessfully as GPM");
				   System.out.println();
				   System.out.println("======================================================================================");
				   System.out.println();
				  
				while(true) {
					System.out.println("\n1. Create an Employee");
					System.out.println("\n2. View List Of Employee.");
					System.out.println("\n3. Allocate  Employee to a project.");
					System.out.println("\n4. Exit");
					int gpmn = sc.nextInt();
					if(gpmn==1) {
						
						System.out.println("Enter Employee Name : ");
						String en = sc.next();
						
						System.out.println("Enter Employee Address : ");
						String ea = sc.next();
											
						Employee employee = new Employee();
						
						employee.setEmpName(en);
						employee.setAddress(ea);
						
						String result = bdodeo.CreateEmployee(employee);
		
						System.out.println(result);
						   System.out.println();
						   System.out.println("======================================================================================");
						
					}
                    if(gpmn==2) {
						
                    	try {
							List<Employee> employees = bdodeo.getAllEmpDetails();
							employees.forEach(s->System.out.println(s));
						}
						catch(EmployeeException ee) {
							System.out.println(ee.getMessage());
							   System.out.println();
							   System.out.println("======================================================================================");
						}
                    	
					}
                    if(gpmn==3) {
						
                    	System.out.println("Enter the Employee Id");
						int empId = sc.nextInt();
						
						System.out.println("Enter the projectId");
						int projId = sc.nextInt();
						
						try {
							String result = bdodeo.AlocateEmptoProject(empId, projId);
									System.out.println(result);
									   System.out.println();
									   System.out.println("======================================================================================");
						} catch (Exception e) {
							// TODO Auto-generated catch block
						   System.out.println(e.getMessage());
						   System.out.println();
						   System.out.println("======================================================================================");
						}	
					}
                    if(gpmn==4) {
                    	break;
					}
				}
				}
				catch(GPMException ge) {
					System.out.println(ge.getMessage());
					   System.out.println();
					   System.out.println("======================================================================================");
				}
				MrnregaApp.selectoption();
				   System.out.println();
				   System.out.println("============================== EXIT ===================================");
			case 3: break;	
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			MrnregaApp.selectoption();
		}
	}

}
