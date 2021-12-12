package com.admindao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.admindto.Fund;
import com.adminfactory.ConnectionFactory;



public class FundDAOImpl implements FundDAO {

	@Override
	public String addCustomer(Fund customer) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			Fund cst = searchCustomer(customer.getAccountNumber());
			if(cst == null) {
				int rowCount = st.executeUpdate("insert into fund values('"+customer.getAccountNumber()+"','"+customer.getCustomerName()+"','"+customer.getCustomerIfsc()+"','"+customer.getCustomerAddress()+"','"+customer.getBalance()+"')");
				if(rowCount == 1) {
					status = "success";
				}else {
					status = "failure";
				}
			}else {
				status = "existed";
			}
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Fund searchCustomer(String accountNumber) {
		Fund customer = null;
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from fund where ACC_NO = '"+accountNumber+"'");
			boolean b = rs.next();
			if(b == true) {
				customer = new Fund();
				customer.setAccountNumber(rs.getString("ACC_NO"));
				customer.setCustomerName(rs.getString("CUST_NAME"));
				customer.setCustomerIfsc(rs.getString("CUST_IFSC"));
				customer.setCustomerAddress(rs.getString("CUST_ADDR"));
				customer.setBalance(rs.getString("TRANS_AMT"));
			}else {
				customer = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	

}
