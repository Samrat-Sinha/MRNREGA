package com.masai.deo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.beam.BDO;
import com.masai.beam.GPM;
import com.masai.beam.Project;
import com.masai.exceptions.BDOException;
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

	
	


}
