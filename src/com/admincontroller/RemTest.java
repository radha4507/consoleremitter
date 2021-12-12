package com.admincontroller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.admindto.Remitter;
import com.adminfactory.RemitterServiceFactory;
import com.adminservice.RemitterService;

public class RemTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		System.out.println("Remitter Operation System");
		System.out.println("================================================================");

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			Remitter customer=null;
			String accountNumber="";
			RemitterService remitterservice = RemitterServiceFactory.getRemitterService();
			while(true){
				System.out.println("1. Enter ACCOUNT-ID to Get details");
				System.out.println("2. Add Beneficiary Account");
				System.out.println("3. Fund Transfer");
				System.out.println("4. Exit");
				System.out.println("your Option : ");
				int option = Integer.parseInt(br.readLine());
				//String customerAddress;
				switch(option) {
				 
				case 1:
					System.out.print("Customer Id    : ");
					accountNumber = br.readLine();
					customer = remitterservice.search(accountNumber);
					if(customer == null) {
						System.out.println("Status   : Customer Not Existed");
					}else {
						System.out.println("================================================================");
						System.out.println("Status   : Customer Existed");
						System.out.println("Customer Details");
						System.out.println("------------------");
						System.out.println("Account Number      : "+customer.getAccountNumber());
						System.out.println("Customer Name    : "+customer.getCustomerName());
						System.out.println("Customer IFSC    : "+customer.getCustomerIfsc());						
						System.out.println("Customer Address : "+customer.getCustomerAddress());
						System.out.println("Customer balance : "+customer.getBalance());
						System.out.println("=================================================================");
					}
					
				break;
				case 2:
					BenfTest.main(args);
				case 3:
					FundTest.main(args);
				case 4:
					System.out.println("================================================================");
					System.out.println("******Thank You for Using Remitter Management System******");
					System.out.println("================================================================");

					System.exit(0);
				break;
				default:
					System.out.println("================================================================");
					System.out.println("Invalid Option , Provide the numbers from 1,2,3 and 4");
					System.out.println("================================================================");

				break;

				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

