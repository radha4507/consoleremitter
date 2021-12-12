package com.adminfactory;
import com.admindao.AdminDAO;
import com.admindao.AdminDAOImpl;

public class AdminDAOFactory {
	private static AdminDAO adminDAO;
	static {
		adminDAO = new AdminDAOImpl();
	}
	public static AdminDAO getAdminDAO()
	{
		return adminDAO;
	}

}
