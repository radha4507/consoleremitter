package com.admindao;
import java.sql.SQLException;

import com.admindto.Fund;

public interface FundDAO {
	public String addCustomer(Fund customer) throws SQLException;
	public Fund searchCustomer(String accountNumber);
	
}

