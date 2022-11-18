package com.masai.deo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Model.BDO;
import com.masai.Model.Employee;
import com.masai.Model.GPM;
import com.masai.Model.Project;
import com.masai.exceptions.BDOException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.GPMException;
import com.masai.utility.DBUtil;


public class BDO_DaoImpl implements BDO_Deo{

	@Override
	public BDO loginBDO(String username, String password) throws BDOException {
		
		BDO bdo =null;
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from bdo where username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String u = rs.getString("username");
				String p = rs.getString("password");
				
				bdo = new BDO(u,p);
			}
			else {
				throw new BDOException("Invalid Username or password..........");
			}
			
			
		}
		catch(SQLException e) {
			throw new BDOException(e.getMessage());
		}
		return bdo;
		
		
		
	}

	@Override
	public String CreateProject(Project project) {
		
		String message = "Not Created";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into project(ProjectDesc,ProjectDist,ProjectVillage) value(?,?,?)");
			
			ps.setString(1, project.getProjectDesc());
			ps.setString(2, project.getProjectDist());
			ps.setString(3, project.getProjectVillage());
			
			int x = ps.executeUpdate();
			
			if (x>0){
				message = "New Project created sucessfully....";
			}
		}
		catch(SQLException e) {
			message = e.getMessage();
		}
		return message;		
	}

	@Override
	public List<Project> getAllProjectDetails() throws BDOException {
		
		List<Project> projects = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from project");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("projectId");
				String ds = rs.getString("projectDesc");
				String dt = rs.getString("projectDist");
				String vl = rs.getString("projectVillage");
				
				
				
			Project project = new Project(id,ds,dt,vl);
			projects.add(project);
			}
		}
		catch(SQLException e) {
			throw new BDOException(e.getMessage());
		}
		
		if(projects.size()==0) {
			throw new BDOException("No Project Created..");
		}
		return projects;
				
	}

	@Override
	public String CreateGPM(GPM gpm) {
		
        String message = "Not Created";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into gpm(gpmname,gpmvillage,gpmemail,gpmpassword) value(?,?,?,?)");
			
			ps.setString(1, gpm.getGpmName());
			ps.setString(2, gpm.getGpmVillage());
			ps.setString(3, gpm.getGpmEmail());
			ps.setString(4, gpm.getGpmpassword());
			
			
			int x = ps.executeUpdate();
			
			if (x>0){
				message = "New Gram Panchayat Member created sucessfully....";
			}
		}
		catch(SQLException e) {
			message = e.getMessage();
		}
		return message;	
		
	}

	@Override
	public List<GPM> getAllGpmDetails() throws BDOException {
	
        List<GPM> gpms = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from gpm");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id    = rs.getInt("gpmId");
				String gn = rs.getString("gpmname");
				String gv = rs.getString("gpmvillage");
				String ge = rs.getString("gpmemail");
				String gp = rs.getString("gpmpassword");
				
				
				
			GPM gpm = new GPM(id,gn,gv,ge,gp);
			gpms.add(gpm);
			}
		}
		catch(SQLException e) {
			throw new BDOException(e.getMessage());
		}
		
		if(gpms.size()==0) {
			throw new BDOException("No Gram Panchayat Member Created..");
		}
		return gpms;
		
	}

	@Override
	public String AlocateGpmtoProject(int gpmId, int projectId) throws BDOException, GPMException {
		String message = "Not Alocated";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
		 	PreparedStatement ps= conn.prepareStatement("select * from project where projectId =?");
			
		 	ps.setInt(1,projectId);
		    
		 	ResultSet rs = ps.executeQuery();
		 	
		 	if(rs.next()) {
		 		
		 		PreparedStatement ps2 =  conn.prepareStatement("select * from gpm where gpmId=?");
		 		
		 		ps2.setInt(1,gpmId);
		 		
		 		ResultSet rs2 = ps2.executeQuery();
		 		
		 		if(rs2.next()) {
		 			
		 			PreparedStatement ps3 = conn.prepareStatement("insert into gpm_project values(?,?)");
		 			
		 			ps3.setInt(1, projectId);
		 			ps3.setInt(2, gpmId);
		 			
		 			int x = ps3.executeUpdate();
		 			
		 			if(x>0) 
		 				message = "GPM alocated to a project";
		 			else 
		 				throw new BDOException("Technical Error..");

		 		}
		 		else 
		 			throw new GPMException("Invalid Gram Panchayat Memeber");
		 		
		 	}
		 	else
		 		throw new BDOException("Invalid Project.. alocated to GPM");
		 	
		}
		 	catch(SQLException e) {
		 		throw new BDOException(e.getMessage());
		 	}
		
		
		return message;
	}

	@Override
	public GPM loginGpm(String gpmusername, String gpmpassword) throws GPMException {
		
		GPM gpm =null;
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from gpm where gpmemail = ? AND gpmpassword = ?");
			ps.setString(1, gpmusername);
			ps.setString(2, gpmpassword);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int gid = rs.getInt("gpmId");
				String ng = rs.getString("gpmname");
				String v = rs.getString("gpmvillage");
				String u = rs.getString("gpmemail");
				String p = rs.getString("gpmpassword");
				
				gpm = new GPM(gid,ng,v,u,p);
			}
			else {
				throw new GPMException("Invalid Username or password..........");
			}
			
			
		}
		catch(SQLException e) {
			throw new GPMException(e.getMessage());
		}
		return gpm;
	}

	@Override
	public String CreateEmployee(Employee employee) {
		
String message = "Not Created Any Employee";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into employee(empName,empAdd) value(?,?)");
			
			ps.setString(1, employee.getEmpName());
			ps.setString(2, employee.getAddress());
			
			
			int x = ps.executeUpdate();
			
			if (x>0){
				message = "New Employee created sucessfully....";
			}
		}
		catch(SQLException e) {
			message = e.getMessage();
		}
		return message;
		
	}

	@Override
	public List<Employee> getAllEmpDetails() throws EmployeeException {
		
		 List<Employee> employees = new ArrayList<>();
			
			try(Connection conn = DBUtil.provideConnection()){
				PreparedStatement ps = conn.prepareStatement("select * from employee");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					int id    = rs.getInt("empId");
					String en = rs.getString("empName");
					String ea = rs.getString("empAdd");

					
					
					
				Employee employee = new Employee(id,en,ea);
				employees.add(employee);
				}
			}
			catch(SQLException e) {
				throw new EmployeeException(e.getMessage());
			}
			
			if(employees.size()==0) {
				throw new EmployeeException("No Employee Member Created..");
			}
			return employees;
		
		
	}

	@Override
	public String AlocateEmptoProject(int empId, int projectId) throws BDOException, EmployeeException {
		
        String message = "Not Alocated";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
		 	PreparedStatement ps= conn.prepareStatement("select * from project where projectId =?");
			
		 	ps.setInt(1,projectId);
		    
		 	ResultSet rs = ps.executeQuery();
		 	
		 	if(rs.next()) {
		 		
		 		PreparedStatement ps2 =  conn.prepareStatement("select * from employee where empId=?");
		 		
		 		ps2.setInt(1,empId);
		 		
		 		ResultSet rs2 = ps2.executeQuery();
		 		
		 		if(rs2.next()) {
		 			
		 			PreparedStatement ps3 = conn.prepareStatement("insert into emp_project values(?,?)");
		 			
		 			ps3.setInt(1, projectId);
		 			ps3.setInt(2, empId);
		 			
		 			int x = ps3.executeUpdate();
		 			
		 			if(x>0) 
		 				message = "Employee alocated to a project";
		 			else 
		 				throw new BDOException("Technical Error..");

		 		}
		 		else 
		 			throw new EmployeeException("Invalid Employee Memeber");
		 		
		 	}
		 	else
		 		throw new BDOException("Invalid Project.. alocated to Employee");
		 	
		}
		 	catch(SQLException e) {
		 		throw new BDOException(e.getMessage());
		 	}
		
		
		return message;
		
	}

	
	


}
