package com.masai.ApplicationStart;


import java.util.List;
import java.util.Scanner;
import com.masai.Exception.BDOException;
import com.masai.Exception.EmployeeException;
import com.masai.Exception.GPMException;
import com.masai.Exception.ProjectException;
import com.masai.Model.Employee;
import com.masai.Model.EmployeeTotalWorkingDays;
import com.masai.Model.GPM;
import com.masai.Model.Project;
import com.masai.UseCases.AllocateProjectToGPM;
import com.masai.UseCases.AssignProjectToEmployee;
import com.masai.UseCases.CreatingEmployeeByGPM;
import com.masai.UseCases.CreatingGPM;
import com.masai.UseCases.LoginBDO;
import com.masai.UseCases.LoginGPM;
import com.masai.UseCases.ProjectCreatedByBDO;
import com.masai.UseCases.RegisterBDO;
import com.masai.UseCases.ViewAllEmployeeOnProject;
import com.masai.UseCases.ViewEmployeeWorkingDetails;
import com.masai.UseCases.getAllEmployee;
import com.masai.UseCases.getAllGPM;
import com.masai.UseCases.getAllProjectOfBDO;


public class StartTheAppilcation {

public static void main(String[] args){
		
		System.out.println(" - - - - - - - - - - - - - - Welcome to MRNREGA - - - - - - - - - - - - - - ");
		System.out.println();
		
	    		
		while(true) {
			
			System.out.println("\nPlease select an option to continue");
			System.out.println("\nType 1 For Register As BDO");
			System.out.println("\nType 2 For BDO Login");
			System.out.println("\nType 3 For GPM Login ");
			System.out.println("\nType 4 For Exit Mgnrega Appication");
			System.out.println();

		    Scanner sc = new Scanner(System.in);
	     	int choice = sc.nextInt();
	     	
		    if(choice==1) {
			String registerbyBDO = RegisterBDO.RegisterAsBDO();
			
			if(registerbyBDO!="Not Inserted!...."){ 
				System.out.println();
				System.out.println(registerbyBDO);
			}
			else {
				System.out.println("Register Unseccessfull Please Register with Valid User Details.......");
			   }
		    }
		    if(choice==2) {
		       String loginbybdo = LoginBDO.loginAsBDO();
		       if(loginbybdo!="Login UnSuccessfull Please Register yourself first!...") {
		    		System.out.println();
					System.out.println(loginbybdo);  
					
					while(true) {
						System.out.println("\nType 1 For Create a Project");
						System.out.println("\nType 2 For View List Of Project.");
						System.out.println("\nType 3 For Create new Gram Panchayat Member(GPM).");
						System.out.println("\nType 4 For View all the Gram Panchayat Member(GPM).");
						System.out.println("\nType 5 For Allocate  Project to Gram Panchayat Member(GPM).");
						System.out.println("\nType 6 For See List of Employee working on that Project and their wages.");
						System.out.println("\nType 7 For Exit");
						System.out.println();
						
						int innerbdochoice = sc.nextInt();
						
						if(innerbdochoice==1) {
							String createAProject = ProjectCreatedByBDO.ProjectCreate();
							if(createAProject!="Not Inserted!....Project already created!.....") {
								System.out.println();
								System.out.println(createAProject);
							}
							else {
								System.out.println();
								System.out.println("Not Inserted!....Project already created!.....");
							}
						}
						if(innerbdochoice==2) {
							
							try {
								List<Project> allprojs = getAllProjectOfBDO.allProject();
								
								if(allprojs.size()!=0) {
								System.out.println("........Project Details........");
								System.out.println();
								allprojs.forEach(p->{
							    System.out.println("Product Id       : " + p.getProjectId());
							    System.out.println("Product Name     : " + p.getProjectName());
							    System.out.println("Product Work     : " + p.getProjectWorkDetail());
							    System.out.println("Product LOcation : " + p.getProjectWorkLocation());
							    System.out.println();
							    System.out.println("===============================================");
							    System.out.println();
							});
								}
								else {
									System.out.println("No Project is created By the BDO");
								}
							} catch (BDOException e) {
								e.printStackTrace();
							}
							
						}
						if(innerbdochoice==3) {
							
							String creatinggpm = CreatingGPM.creategpmbybdo();
							if(creatinggpm!="Not Inserted!....GPM already created!.....") {
								System.out.println();
								System.out.println(creatinggpm);
							}
							else {
								System.out.println("Not Inserted as GPM already created!.....");
							}
						}
						if(innerbdochoice==4) {
							List<GPM> allgpms = getAllGPM.allgpm();
							if(allgpms.size()==0) {
								System.out.println("No GPM is created by BDO!.....");
							}
							else {
								System.out.println();
								System.out.println("........ALL Gram Panchayat Member........");
								System.out.println();
								allgpms.forEach(p->{
							    System.out.println("Gram Panchayat Member Id           : " + p.getGpmID());
							    System.out.println("Gram Panchayat Member Id  Name     : " + p.getGpmName());
							    System.out.println("Gram Panchayat Member Id  Work     : " + p.getGpmAddress());
							    System.out.println("Gram Panchayat Member Id  LOcation : " + p.getGpmEmail());
							    System.out.println("Gram Panchayat Member Id  Password : " + p.getGpmpassword());
							    System.out.println();
							    System.out.println("===============================================");
										});
								
							}
						}
						if(innerbdochoice==5) {
							String projToGpm;
							try {
								projToGpm = AllocateProjectToGPM.projectToGPM();
								
								if(projToGpm!="GPM has not been Allocated to any Project") {
									System.out.println();
									System.out.println(projToGpm);
								}
								else {
									System.out.println("GPM has not been Allocated to any Project");
								}
							} catch (GPMException | ProjectException e) {
								System.out.println(e.getMessage());
							}
						}
						if(innerbdochoice==6) {
							try {
								List<EmployeeTotalWorkingDays> allemp= ViewAllEmployeeOnProject.getallworkdata();
								
								if(allemp.size()!=0) {
								System.out.println();
						        System.out.println("Total Employee Details working on project :");
						        System.out.println();
							    	allemp.forEach(eTWD->{
									System.out.println("Employee Id                  : "+ eTWD.getEmployeeId());
									System.out.println("Employee Name                : "+eTWD.getEmployeeName());
									System.out.println("Employee Skill               : "+eTWD.getEmployeeSkill());
									System.out.println("Employee Project Name        : " +eTWD.getProjectName());
									System.out.println("Employee Assign Working Days : "+eTWD.getAssignDays());
									System.out.println("Employee Absent Days         : "+eTWD.getNoOfAbsentDays());
									System.out.println("Employee Total Working Days  : "+eTWD.getNoOfWorkingDays());
									System.out.println("Employee Total Wages         : "+eTWD.getWages());
								    System.out.println();
								    System.out.println("===============================================");
								    System.out.println();
											});
								}
								else {
									System.out.println( );
									System.out.println("No Employee is Assign to Work........");
								}
							} catch (EmployeeException e) {
								e.printStackTrace();
							}	
						}
						if(innerbdochoice==7) {
							break;
						}
						
					}
		       }
		       else {
		    	   System.out.println("Register Unseccessfull Please Register youself First......");
		       }
		    }
		    if(choice==3) {
		    	
		    	try {
					String loginbyGpm = LoginGPM.loginAsGpm();
					
					if(loginbyGpm!="Login UnSuccessfull Please ask BDO to Register you!...") {
						System.out.println();
						System.out.println(loginbyGpm);
						
						while(true) {
							System.out.println();
							System.out.println("---------------------------------------------------------------------------------------------");
							System.out.println("\nPlease select an option to continue ");
							System.out.println();
							System.out.println("\nType 1 For Create an Employee");
							System.out.println("\nType 2 For View List Of Employee");
							System.out.println("\nType 3 For Assign Employee to a project.");
							System.out.println("\nType 4 For View total number of days Employee worked in a project and also their wages.");
							System.out.println("\nType 5 For Exit");
							System.out.println();
							System.out.println("---------------------------------------------------------------------------------------------");
							System.out.println();
							
						
							
							int innergpmchoice = sc.nextInt();
							
							if(innergpmchoice==1) {
								try {
									String createemp = CreatingEmployeeByGPM.creatingemployee();
									if(createemp!="Not Inserted!....Employee already created!.....") {
										System.out.println();
										System.out.println(createemp);
									}
									else {
										System.out.println("Not Inserted!....Employee already created!.....");
									}
								} catch (EmployeeException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							if(innergpmchoice==2) {
								List<Employee> allemp = getAllEmployee.viewAllEmp();
								
								if(allemp.size()!=0) {
									allemp.forEach(p->{
										System.out.println();
								    System.out.println("Employee Id                 : " + p.getEmpId());
								    System.out.println("Employee Name               : " + p.getName());
								    System.out.println("Employer Working Status     : " + p.getSkill());
								    System.out.println();
								    System.out.println("===============================================");
											});
								}
								else {
									System.out.println("None of a single employee is been created by Gram Panchayat Member");
								}
							}
							if(innergpmchoice==3) {
								String assignEmps = AssignProjectToEmployee.AssignEmp();
								if(assignEmps!="Employee has not been Allocated to any Project") {
									System.out.println();
									System.out.println(assignEmps);
								}
								else {
									System.out.println("Employee has not been Allocated to any Project");
								}
								
							}
							if(innergpmchoice==4) {
								EmployeeTotalWorkingDays empDetails = ViewEmployeeWorkingDetails.EmployeeTotalWorkDetails();
							if(empDetails == null) {
								System.out.println("No Employer is Assign to Work on Projects");
								
							}
							else {
								System.out.println("Employee Work Detail");
								System.out.println();
							System.out.println("Employee Id                  : "+ empDetails.getEmployeeId());
							System.out.println("Employee Name                : "+ empDetails.getEmployeeName());
							System.out.println("Employee Skill               : "+ empDetails.getEmployeeSkill());
							System.out.println("Employee Project Name        : "+ empDetails.getProjectName());
							System.out.println("Employee Assign Working Days : "+ empDetails.getAssignDays());
							System.out.println("Employee Absent Days         : "+ empDetails.getNoOfAbsentDays());
							System.out.println("Employee Total Working Days  : "+ empDetails.getNoOfWorkingDays());
							System.out.println("Employee Total Wages         : Rs "+ empDetails.getWages());
							}
							}
							if(innergpmchoice==5) {
								break;
							}
						}
					}
					else {
						System.out.println("Login UnSuccessfull Please ask BDO to Register you!...");
					}
					
				} catch (GPMException e) {
					e.printStackTrace();
				}
		    	
		    }
		    if(choice==4) {
		    	System.out.println();
		    	System.out.println("Application Closed Successfully");
		    	System.out.println();
		    	System.out.println("--------------------------THANK YOU FOR RUNNING MGNREGA APPLICATION--------------------------");
		    	break;
		    }
		    
	 }
   }
	
}
