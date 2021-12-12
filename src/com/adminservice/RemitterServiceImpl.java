package com.adminservice;




import com.admindao.RemitterDAO;
import com.admindto.Remitter;
import com.adminfactory.RemitterDAOFactory;

public class RemitterServiceImpl implements RemitterService {

	

	@Override
	public Remitter search(String accountNumber) {
		RemitterDAO customerDao = RemitterDAOFactory.getRemitterDAO();
		Remitter customer = customerDao.searchCustomer(accountNumber); 
		return customer;
	}

	


}
