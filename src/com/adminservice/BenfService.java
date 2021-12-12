package com.adminservice;


import java.sql.SQLException;

import com.admindto.Benf;

public interface BenfService {
	public String add(Benf beneficiary) throws SQLException  ;
	public Benf search(String beneficiaryNumber);
	public String update(Benf beneficiary);
	public String delete(String beneficiaryNumber);
}
	
