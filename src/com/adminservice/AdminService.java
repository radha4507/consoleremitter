package com.adminservice;


import java.sql.SQLException;

import com.admindto.Admin;

public interface AdminService {
	public String add(Admin customer) throws SQLException  ;
	public Admin search(String accountNumber);
	public String update(Admin customer);
	public String delete(String accountNumber);
}
	


