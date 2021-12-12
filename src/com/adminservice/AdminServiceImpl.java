package com.adminservice;

import java.sql.SQLException;

//import java.sql.SQLException;


import com.admindao.AdminDAO;
import com.admindto.Admin;
import com.adminfactory.AdminDAOFactory;

public class AdminServiceImpl implements AdminService {

	@Override
	public String add(Admin customer) throws SQLException  
	{
		AdminDAO customerDao = AdminDAOFactory.getAdminDAO();
		String status = customerDao.addCustomer(customer);
		
		return status;
	}

	@Override
	public Admin search(String accountNumber) {
		AdminDAO customerDao = AdminDAOFactory.getAdminDAO();
		Admin customer = customerDao.searchCustomer(accountNumber); 
		return customer;
	}

	@Override
	public String update(Admin newCustomer) {
		AdminDAO customerDao = AdminDAOFactory.getAdminDAO();
		String status = customerDao.updateCustomer(newCustomer);
		return status;
	}

	@Override
	public String delete(String accountNumber) {
		AdminDAO customerDao = AdminDAOFactory.getAdminDAO();
		String status = customerDao.deleteCustomer(accountNumber);
		return status;
	}

}
