package com.admindao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.admindto.Remitter;
import com.adminfactory.ConnectionFactory;



public class RemitterDAOImpl implements RemitterDAO {

	

	@Override
	public Remitter searchCustomer(String accountNumber) {
		Remitter customer = null;
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from admin where accountNumber = '"+accountNumber+"'");
			boolean b = rs.next();
			if(b == true) {
				customer = new Remitter();
				customer.setAccountNumber(rs.getString("accountNumber"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setCustomerIfsc(rs.getString("customerIfsc"));
				customer.setCustomerAddress(rs.getString("customerAddress"));
				customer.setBalance(rs.getString("balance"));
			}else {
				customer = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	
	

}
