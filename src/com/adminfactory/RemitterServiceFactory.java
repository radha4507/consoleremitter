package com.adminfactory;

import com.adminservice.RemitterService;
import com.adminservice.RemitterServiceImpl;

public class RemitterServiceFactory {
	private static  RemitterService remitterservice;
	static {
		remitterservice =  new RemitterServiceImpl();
		
	}
	public static RemitterService getRemitterService() {
		return remitterservice;
	}

}
