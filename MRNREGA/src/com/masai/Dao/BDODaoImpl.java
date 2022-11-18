package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Model.BDO;
import com.masai.Model.GPM;
import com.masai.Model.Project;
import com.masai.exceptions.BDOException;
import com.masai.exceptions.EmployeeException;
import com.masai.exceptions.GPMException;
import com.masai.exceptions.ProjectException;
import com.masai.utility.DBUtil;


public class BDODaoImpl implements BDODao{

	@Override
	public String registerAsBDO(BDO bdo) {
      
		String message = "Not Inserted!....";
		
		boolean ans=false;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
		PreparedStatement ps1 = conn.prepareStatement("select * from BDO where name=? && email=?");
		
		ps1.setString(1, bdo.getName());
		ps1.setString(2, bdo.getEmail());

		ResultSet rs1 = ps1.executeQuery();
		
		if(rs1.next()) {
			ans=false;
		}
		else {
		
        PreparedStatement ps = conn.prepareStatement("insert into BDO(name,email,password) values(?,?,?)"); 
		       
        ps.setString(1, bdo.getName());
        ps.setString(2, bdo.getEmail());
        ps.setString(3, bdo.getPassword());
        
        int x = ps.executeUpdate();
        
        if(x>0) {
        	message = "Congratulation " + bdo.getName() + " You are Registered Successfully !.....";
        ans=true;
        }
		}       
        
		} catch (SQLException sqle) {
			message = sqle.getMessage(); 
		}
//		return ans;
		return message;
	}

	@Override
	public String loginAsBDO(String email, String password) {
        String message = "Login UnSuccessfull Please Register yourself first!...";
		
//		boolean ans1 = false;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select email,password from BDO where email=? && password=?");
			PreparedStatement ps1 = conn.prepareStatement("insert into BDOlogin values(?,?)");
			
			ps.setString(1, email);
			ps.setString(2, password);	
			
			
			
			 ResultSet rs = ps.executeQuery();
			
			 if(rs.next()) {
				 	message = "Login Successfull";
//				 ans1=true;
				 	ps1.setString(1, email);
					ps1.setString(2, password);
					ps1.executeUpdate();
			 }
			
		} catch (SQLException sqle) {
			message = sqle.getMessage();
		}
		return message;
	}

	@Override
	public String createProject(Project project) {
	  
        String message = "Not Inserted!....Project already created!.....";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
		PreparedStatement ps = conn.prepareStatement("select projectName,projectWorkLocation from BDOproject where projectName=? && projectWorkLocation=?");
        PreparedStatement ps1 = conn.prepareStatement("insert into BDOproject(projectName,projectWorkDetail,projectWorkLocation) values(?,?,?)"); 
        
        ps.setString(1, project.getProjectName());
        ps.setString(2, project.getProjectWorkLocation());
        
        ResultSet rs = ps.executeQuery();
        
        if(!rs.next()) {
        	ps1.setString(1, project.getProjectName());
        	ps1.setString(2,project.getProjectWorkDetail());
            ps1.setString(3, project.getProjectWorkLocation());
            ps1.executeUpdate();
            message = "Congratulation Project : " + project.getProjectName()  + " has been created Successfully !.....";
        }    
		} catch (SQLException sqle) {
			message = sqle.getMessage(); 
		}
		return message;
		
	}

	@Override
	public List<Project> getAllProject() throws BDOException{
		List<Project> projects = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			 
			PreparedStatement ps =  conn.prepareStatement("select * from BDOproject");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int pid = rs.getInt("projectId");
				String pn = rs.getString("projectName");
				String pw = rs.getString("projectWorkDetail");
				String pl = rs.getString("projectWorklocation");
				 
				Project proj = new Project(pid,pn,pw,pl);
				projects.add(proj);
//				System.out.println(projects);
			}
		} catch (SQLException sqle) {
			throw new BDOException(sqle.getMessage());
		}
		
		if(projects.size()==0) {
			throw new BDOException("No Project Found");
		}
		
		return projects;
	}

	@Override
	public String registerGPMbyBDO(GPM gpm) {
        String message = "Not Inserted!....GPM already created!.....";
        
        try(Connection conn = DBUtil.provideConnection()) {
			
        	PreparedStatement ps = conn.prepareStatement("select gpmName from GPM where gpmName=?");
        	PreparedStatement ps1 = conn.prepareStatement("insert into GPM(gpmName,gpmAddress,gpmEmail,gpmpassword) values(?,?,?,?)");
        	
        	ps.setString(1, gpm.getGpmName());

        	
        	ResultSet rs = ps.executeQuery();
        	
        	if(!rs.next()) {
        		
        		ps1.setString(1, gpm.getGpmName());
        		ps1.setString(2, gpm.getGpmAddress());
        		ps1.setString(3, gpm.getGpmEmail());
        		ps1.setString(4, gpm.getGpmpassword());
        		
        		ps1.executeUpdate();
        		message = "Congratulation GPM " + gpm.getGpmName() + " is Registered Successfully !.....";
        	}
		} catch (SQLException e) {
			message=e.getMessage();
		}
        return message;
	}

	@Override
	public List<GPM> getAllGPM() {
        List<GPM> gpms = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			 
			PreparedStatement ps =  conn.prepareStatement("select * from GPM");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				int gpmid = rs.getInt("gpmID");
				String gpmn = rs.getString("gpmName");
				String gpmadd = rs.getString("gpmEmail");
				String gpmemail = rs.getString("gpmpassword");
				String gpmpass = rs.getString("gpmAddress");
				
				GPM addgpm = new GPM(gpmid, gpmn, gpmemail, gpmpass, gpmadd);
				gpms.add(addgpm);
//				System.out.println(projects);
			}
		} catch (SQLException sqle) {
			sqle.getMessage();
		}
		return gpms;
	}

	@Override
	public String allocateGpmInsideProject(int gpmId, String gpmName, int projectId, String projectName) throws GPMException, ProjectException {
		String message = "GPM has not been Allocated to any Project.........................";
		message = "ok till line 223";
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from GPM where gpmId=? && gpmName=?");
			ps.setInt(1, gpmId);
			ps.setString(2, gpmName);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				PreparedStatement ps1 = conn.prepareStatement("select * from BDOproject where projectId=? && projectName=?");
				ps1.setInt(1,projectId);
				ps1.setString(2,projectName);
				message = "ok till line 231";
				ResultSet rs1 = ps1.executeQuery();
				
				if(rs1.next()) {
					
					PreparedStatement ps11 = conn.prepareStatement("select * from Gpm_Project where gpmID=? && projectId=?");
					
					ps11.setInt(1, gpmId);
					ps11.setInt(2, projectId);
					
					ResultSet rs11 = ps11.executeQuery();
					
					if(rs11.next()) {
						message = "GPM has already been Allocated to that Project Earlier";
					}
					else {
					PreparedStatement ps2 = conn.prepareStatement("insert into Gpm_Project values(?,?,?,?)");
					ps2.setInt(1, gpmId);
					ps2.setInt(2,projectId);
					ps2.setString(3, gpmName);
					ps2.setString(4,projectName);
					
					ps2.executeUpdate();
					message = "GPM : "+ gpmName +" is allocated to a Project named " + projectName + " Successfully";
					}
				}
				else {
					throw new ProjectException("Invalid Project");
				}
			}
			else {
				throw new GPMException("Invalid GPM ");
			}
			
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		return message;
	}


	
	

	
	


}
