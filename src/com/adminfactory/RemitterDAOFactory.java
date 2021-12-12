package com.adminfactory;
import com.admindao.RemitterDAO;
import com.admindao.RemitterDAOImpl;

public class RemitterDAOFactory {
	private static RemitterDAO remitterDAO;
	static {
		remitterDAO = new RemitterDAOImpl();
	}
	public static RemitterDAO getRemitterDAO()
	{
		return remitterDAO;
	}

}

