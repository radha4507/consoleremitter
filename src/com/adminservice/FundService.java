package com.adminservice;


import java.sql.SQLException;

import com.admindto.Fund;

public interface FundService {
	public String add(Fund customer) throws SQLException  ;
	public Fund search(String accountNumber);
}
	


