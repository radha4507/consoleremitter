package com.adminfactory;
import com.admindao.BenfDAO;
import com.admindao.BenfDAOImpl;

public class BenfDAOFactory {
	private static BenfDAO benfDAO;
	static {
		benfDAO = new BenfDAOImpl();
	}
	public static BenfDAO getBenfDAO()
	{
		return benfDAO;
	}

}
