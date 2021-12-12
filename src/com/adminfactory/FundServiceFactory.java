package com.adminfactory;

import com.adminservice.FundService;
import com.adminservice.FundServiceImpl;

public class FundServiceFactory {
	private static  FundService adminservice;
	static {
		adminservice = new FundServiceImpl();
		
	}
	public static FundService getFundService() {
		return adminservice;
	}

}
