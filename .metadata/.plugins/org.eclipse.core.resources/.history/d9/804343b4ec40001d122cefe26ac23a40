package com.masai.deo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.beam.BDO;
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
				throw new BDOException("Invalid Username or password");
			}
			
			
		}
		catch(SQLException e) {
			throw new BDOException(e.getMessage());
		}
		return bdo;
		
		
		
	}

	


}
