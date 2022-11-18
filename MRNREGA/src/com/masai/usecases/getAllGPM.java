package com.masai.usecases;

import java.util.List;

import com.masai.Dao.BDODao;
import com.masai.Dao.BDODaoImpl;
import com.masai.Model.GPM;

public class getAllGPM {


public static List<GPM> allgpm() {
		
		BDODao dao = new BDODaoImpl();
		
			List<GPM> allgpm = dao.getAllGPM();

			return allgpm;
			
//			allgpms.forEach(p->{
//			    System.out.println("GPM Id       : " + p.getGpmID());
//			    System.out.println("GPM Name     : " + p.getGpmName());
//			    System.out.println("GPM Work     : " + p.getGpmAddress());
//			    System.out.println("GPM LOcation : " + p.getGpmEmail());
//			    System.out.println("GPM Password : " + p.getGpmpassword());
//			    System.out.println();
//			    System.out.println("===============================================");
//						});
}
	
}
