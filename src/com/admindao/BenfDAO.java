package com.admindao;
import java.sql.SQLException;

import com.admindto.Benf;

public interface BenfDAO {
	public String addBeneficiary(Benf beneficiary) throws SQLException;
	public Benf searchBeneficiary(String beneficiaryNumber);
	public String updateBeneficiary(Benf beneficiary);
	public String deleteBeneficiary(String beneficiaryNumber);
	
}
