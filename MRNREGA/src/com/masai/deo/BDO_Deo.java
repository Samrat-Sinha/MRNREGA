package com.masai.deo;

import com.masai.beam.BDO;
import com.masai.exceptions.BDOException;

public interface BDO_Deo {
	
	public BDO loginBDO(String username,String password)throws BDOException;

}
