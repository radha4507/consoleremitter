package com.admindao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.admindto.Admin;
import com.adminfactory.ConnectionFactory;



public class AdminDAOImpl implements AdminDAO {

	@Override
	public String addCustomer(Admin customer) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			Admin cst = searchCustomer(customer.getAccountNumber());
			if(cst == null) {
				int rowCount = st.executeUpdate("insert into admin values('"+customer.getAccountNumber()+"','"+customer.getCustomerName()+"','"+customer.getCustomerIfsc()+"','"+customer.getCustomerAddress()+"','"+customer.getBalance()+"')");
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
	public Admin searchCustomer(String accountNumber) {
		Admin customer = null;
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from admin where accountNumber = '"+accountNumber+"'");
			boolean b = rs.next();
			if(b == true) {
				customer = new Admin();
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

	@Override
	public String updateCustomer(Admin newCustomer) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			int rowCount = st.executeUpdate("update admin set customerName = '"+newCustomer.getCustomerName()+"',customerIfsc = '"+newCustomer.getCustomerIfsc()+"', customerAddress = '"+newCustomer.getCustomerAddress()+"',balance='"+newCustomer.getBalance()+"' where accountNumber = '"+newCustomer.getAccountNumber()+"'");
			if(rowCount == 1) {
				status = "success";
			}else {
				status = "failure";
			}
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String deleteCustomer(String accountNumber) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			Admin customer = searchCustomer(accountNumber);
			if(customer == null) {
				status = "notexisted";
			}else {
				int rowCount = st.executeUpdate("delete from admin where accountNumber = '"+accountNumber+"'");
				if(rowCount == 1) {
					status = "success";
				}else {
					status = "failure";
				}
			}
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}

}
