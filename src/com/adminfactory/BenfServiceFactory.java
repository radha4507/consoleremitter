package com.adminfactory;

import com.adminservice.BenfService;
import com.adminservice.BenfServiceImpl;


public class BenfServiceFactory {
	private static  BenfService benfservice;
	static {
		benfservice = new BenfServiceImpl();
		
	}
	public static BenfService getBenfService() {
		return benfservice;
	}

}

