package com.admindao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.admindto.Benf;
import com.adminfactory.ConnectionFactory;



public class BenfDAOImpl implements BenfDAO {

	@Override
	public String addBeneficiary(Benf beneficiary) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			Benf cst = searchBeneficiary(beneficiary.getBeneficiaryNumber());
			if(cst == null) {
				int rowCount = st.executeUpdate("insert into beneficiary values('"+beneficiary.getBeneficiaryNumber()+"', '"+beneficiary.getBeneficiaryName()+"', '"+beneficiary.getAccountNumber()+"','"+beneficiary.getBeneficiaryIfsc()+"','"+beneficiary.getBranchName()+"')");
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
	public Benf searchBeneficiary(String beneficiaryNumber) {
		Benf beneficiary = null;
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from beneficiary where beneficiaryNumber = '"+beneficiaryNumber+"'");
			boolean b = rs.next();
			if(b == true) {
				beneficiary = new Benf();
				beneficiary.setBeneficiaryNumber(rs.getString("beneficiaryNumber"));
				beneficiary.setBeneficiaryName(rs.getString("beneficiaryName"));
				beneficiary.setAccountNumber(rs.getString("accountNumber"));
				beneficiary.setBeneficiaryIfsc(rs.getString("beneficiaryIfsc"));				
				beneficiary.setBranchName(rs.getString("branchName"));
			}else {
				beneficiary = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beneficiary;
	}

	@Override
	public String updateBeneficiary(Benf newBeneficiary) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			int rowCount = st.executeUpdate("update beneficiary set beneficiaryNumber = '"+newBeneficiary.getBeneficiaryNumber()+"',beneficiaryName = '"+newBeneficiary.getBeneficiaryName()+"', accountNumber='"+newBeneficiary.getAccountNumber()+"',beneficiaryIfsc = '"+newBeneficiary.getBeneficiaryIfsc()+"',branchName='"+newBeneficiary.getBranchName()+"' where beneficiaryNumber = '"+newBeneficiary.getBeneficiaryNumber()+"'");
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
	public String deleteBeneficiary(String beneficiaryNumber) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			Benf beneficiary = searchBeneficiary(beneficiaryNumber);
			if(beneficiary == null) {
				status = "notexisted";
			}else {
				int rowCount = st.executeUpdate("delete from beneficiary where beneficiaryNumber = '"+beneficiaryNumber+"'");
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

