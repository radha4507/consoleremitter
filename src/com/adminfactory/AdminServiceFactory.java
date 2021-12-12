package com.adminfactory;

import com.adminservice.AdminService;
import com.adminservice.AdminServiceImpl;

public class AdminServiceFactory {
	private static  AdminService adminservice;
	static {
		adminservice = new AdminServiceImpl();
		
	}
	public static AdminService getAdminService() {
		return adminservice;
	}

}
