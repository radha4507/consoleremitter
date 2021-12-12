package com.adminfactory;
import com.admindao.FundDAO;
import com.admindao.FundDAOImpl;

public class FundDAOFactory {
	private static FundDAO adminDAO;
	static {
		adminDAO = new FundDAOImpl();
	}
	public static FundDAO getFundDAO()
	{
		return adminDAO;
	}

}
