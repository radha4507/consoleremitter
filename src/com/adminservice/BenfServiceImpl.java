package com.adminservice;

import java.sql.SQLException;

import com.admindao.BenfDAO;
import com.admindto.Benf;
import com.adminfactory.BenfDAOFactory;

public class BenfServiceImpl implements BenfService {

	@Override
	public String add(Benf beneficiary) throws SQLException  
	{
		BenfDAO beneficiaryDao = BenfDAOFactory.getBenfDAO();
		String status = beneficiaryDao.addBeneficiary(beneficiary);
		
		return status;
	}

	@Override
	public Benf search(String beneficiaryNumber) {
		BenfDAO beneficiaryDao = BenfDAOFactory.getBenfDAO();
		Benf beneficiary = beneficiaryDao.searchBeneficiary(beneficiaryNumber); 
		return beneficiary;
	}

	@Override
	public String update(Benf newBeneficiary) {
		BenfDAO beneficiaryDao = BenfDAOFactory.getBenfDAO();
		String status = beneficiaryDao.updateBeneficiary(newBeneficiary);
		return status;
	}

	@Override
	public String delete(String beneficiaryNumber) {
		BenfDAO beneficiaryDao = BenfDAOFactory.getBenfDAO();
		String status = beneficiaryDao.deleteBeneficiary(beneficiaryNumber);
		return status;
	}

}
