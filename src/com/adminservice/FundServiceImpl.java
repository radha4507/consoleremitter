package com.adminservice;

import java.sql.SQLException;

//import java.sql.SQLException;


import com.admindao.FundDAO;
import com.admindto.Fund;
import com.adminfactory.FundDAOFactory;

public class FundServiceImpl implements FundService {

	@Override
	public String add(Fund customer) throws SQLException  
	{
		FundDAO customerDao = FundDAOFactory.getFundDAO();
		String status = customerDao.addCustomer(customer);
		
		return status;
	}

	@Override
	public Fund search(String accountNumber) {
		FundDAO customerDao = FundDAOFactory.getFundDAO();
		Fund customer = customerDao.searchCustomer(accountNumber); 
		return customer;
	}

	
}
