package com.admindao;
import java.sql.SQLException;

import com.admindto.Admin;

public interface AdminDAO {
	public String addCustomer(Admin customer) throws SQLException;
	public Admin searchCustomer(String accountNumber);
	public String updateCustomer(Admin customer);
	public String deleteCustomer(String accountNumber);
	
}
