package com.adminservice;


//import java.sql.SQLException;

//import com.admindto.Admin;
import com.admindto.Remitter;

public interface RemitterService {
	//public String add(Admin customer) throws SQLException  ;
	public Remitter search(String accountNumber);
	//public String update(Admin customer);
	//public String delete(String accountNumber);
}
	


