package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Model.Employee;
import com.masai.Model.EmployeeTotalWorkingDays;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.GPMException;
import com.masai.exceptions.ProjectException;
import com.masai.utility.DBUtil;

public class GPMDaoImpl implements GPMDao{
	

	@Override
	public String loginAsGPM(String email, String password) throws GPMException {
        String message = "Login UnSuccessfull Please ask BDO to Register you!...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select gpmEmail,gpmpassword from GPM where gpmEmail=? && gpmpassword=?");
					
			ps.setString(1, email);
			ps.setString(2, password);	
			
	        ResultSet rs = ps.executeQuery();
			
			 if(rs.next()) {
				 	message = "Login Successfull as GPM";
			 }
		} catch (SQLException sqle) {
			throw new GPMException("Login UnSuccessfull Please ask BDO to Register you!...");
		}
		return message;
	}

	@Override
	public String createEmployee(Employee employee) throws EmployeeException {
        String message = "Not Inserted!....Employee already created!.....";
        
        try(Connection conn = DBUtil.provideConnection()) {
			
        	PreparedStatement ps = conn.prepareStatement("select * from Employee where emplName=?");
        	
        	ps.setString(1, employee.getName());
        	
        	ResultSet rs = ps.executeQuery();
        	
        	if(rs.next()) {
        	message = "Not Inserted!....Employee already created!.....";
        	}
        	else {
        		PreparedStatement ps1 = conn.prepareStatement("insert into Employee(emplName,emplskill,wages) values(?,?,?)");
        		ps1.setString(1, employee.getName());
        		ps1.setString(2, employee.getSkill());
        		ps1.setInt(3, employee.getWages());
        		
        		int x = ps1.executeUpdate();
        		
        		if(x>0) {
        			message = "Employee : "+employee.getName()+ " Inserted by GPM";
        		}
        		
        	}
		} catch (SQLException e) {
			message = e.getMessage();	
		}
        return message;
	}

	@Override
	public List<Employee> getAllEmployee() {
        List<Employee> emp = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			 
			PreparedStatement ps =  conn.prepareStatement("select * from Employee");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				int eid = rs.getInt("emplId");
				String en = rs.getString("emplName");
				String ews = rs.getString("emplSkill");
				int wages = rs.getInt("wages");
				
				Employee empl = new Employee(eid, en, ews,wages);
				emp.add(empl);
			}
		} catch (SQLException sqle) {
			sqle.getMessage();
		}
		return emp;
	}

	@Override
	public String allocateEmployeeInsideProject(int empId, String name, int projectId, String projectName,int noOfWorkingDays)
			throws EmployeeException, ProjectException {
        String message = "Employee has not been Allocated to any Project";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from Employee where emplId=? && emplname=?");
			ps.setInt(1, empId);
			ps.setString(2, name);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				PreparedStatement ps1 = conn.prepareStatement("select * from BDOproject where projectId=? && projectName=?");
				ps1.setInt(1,projectId);
				ps1.setString(2,projectName);
				
				ResultSet rs1 = ps1.executeQuery();
				
				if(rs1.next()) {
					
					PreparedStatement ps11 = conn.prepareStatement("select * from employee_Project where emplId=? && projectId=?");
					
					ps11.setInt(1, empId);
					ps11.setInt(2, projectId);
					
					ResultSet rs11 = ps11.executeQuery();
					
					if(rs11.next()) {
					message = "Error :- Employer - "+ name + " has been already Assign to the Project - " + projectName;
					}
					else {
					
					PreparedStatement ps2 = conn.prepareStatement("insert into employee_Project values(?,?,?,?,?)");
					ps2.setInt(1, empId);
					ps2.setInt(2,projectId);
					ps2.setString(3, name);
					ps2.setString(4,projectName);
					ps2.setInt(5, noOfWorkingDays);
					
					int x = ps2.executeUpdate();
					
					if(x>0) {
						message = "Employee Name : "+ name +" is allocated to a Project named " + projectName + " Successfully for " +noOfWorkingDays+" days";
					}
					else {
						throw new EmployeeException("Technical Error");
					}
				  }
				}
				else {
					throw new ProjectException("Invalid Project");
				}
			}
			else {
				throw new EmployeeException("Invalid GPM");
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		return message;
	}

	@Override
	public EmployeeTotalWorkingDays viewTotalNumberOfWorkingdays(int employeeId, String employeeName, int absentdays) {
    
//		String ans = "not done";
		EmployeeTotalWorkingDays etwd = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			
            PreparedStatement ps1 = conn.prepareStatement("select * from Employee where emplId=?");
			
			ps1.setInt(1, employeeId);
//			ans = "not done 1";
//			etwd = new EmployeeTotalWorkingDays(employeeId, "00", "00", 10, 0, absentdays, employeeId, absentdays);
			ResultSet rs1 = ps1.executeQuery();
			
                if(rs1.next()) {
				
                	
				String en = rs1.getString("emplName");
				String es = rs1.getString("emplSkill");
				
                PreparedStatement ps2 = conn.prepareStatement("select * from Employee_project where emplId=?");
				
				ps2.setInt(1, employeeId);
				
				
				ResultSet rs2 = ps2.executeQuery();
				
				
				if(rs2.next()) {
//					ans = "not done 3";
					String pn = rs2.getString("projectName");
					int twd = rs2.getInt("workingDay");
					int wrkd = twd-absentdays;
					int ew =rs1.getInt("wages")*wrkd;
//					ans = "done";
					
					PreparedStatement ps31 = conn.prepareStatement("select * from Employee_WorkingDetail where employeeName=? && projectName=?");
					
					ps31.setString(1, employeeName);
					ps31.setString(2, pn);
					
					ResultSet rs21 = ps31.executeQuery();
					
					if(rs21.next()) {
					
						PreparedStatement ps111 = conn.prepareStatement("Update employee_workingDetail set noOfAbsentDays=?,noOfWorkingDays=?,wages=? where employeeId=?");
						ps111.setInt(1, absentdays);
						ps111.setInt(2,wrkd);
						ps111.setInt(3, ew);
						ps111.setInt(4, employeeId);
						
						ps111.execute();
						
						etwd=new EmployeeTotalWorkingDays(employeeId, en, es,pn, twd, absentdays, wrkd, ew);
//						
						return etwd;
//						ans= "not done till 213";
					}
					else {
					PreparedStatement ps3 = conn.prepareStatement("insert into Employee_WorkingDetail values(?,?,?,?,?,?,?,?)");
					ps3.setInt(1,employeeId);
					ps3.setString(2, en);
					ps3.setString(3, es);
					ps3.setString(4, pn);
					ps3.setInt(5, twd);
					ps3.setInt(6, absentdays);
					ps3.setInt(7, wrkd);
					ps3.setInt(8, ew);
					
					int x = ps3.executeUpdate();
					if(x>0) {
						etwd=new EmployeeTotalWorkingDays(employeeId, en, es,pn, twd, absentdays, wrkd, ew);
					}
					}
		    		}
                }	
		} catch (Exception e) {
			// TODO: handle exception
		}
//		return ans;
		return etwd;
	}

	@Override
	public List<EmployeeTotalWorkingDays> getAllEmployeeOfProject() {
         List<EmployeeTotalWorkingDays> emp = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			 
			PreparedStatement ps =  conn.prepareStatement("select * from employee_workingdetail");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				int eid = rs.getInt("employeeId");
				String en = rs.getString("employeeName");
				String ews = rs.getString("employeeSkill");
				String pn = rs.getString("projectName");
				int ad = rs.getInt("assignDays");
				int noa = rs.getInt("noOfAbsentDays");
				int nop = rs.getInt("noOfWorkingDays");
				int wages = rs.getInt("wages");
				
				EmployeeTotalWorkingDays ews1 = new EmployeeTotalWorkingDays(eid, en, ews, pn, ad, noa, nop, wages);
				emp.add(ews1);
			}
		} catch (SQLException sqle) {
			sqle.getMessage();
		}
		return emp;
		
		
	}

	


}
