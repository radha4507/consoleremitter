package com.admincontroller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.admindto.Admin;
import com.adminfactory.AdminServiceFactory;
import com.adminservice.AdminService;

public class Test {

	public static void main(String[] args) {
		BufferedReader br = null;
		System.out.println("Admin Operation System");
		System.out.println("================================================================");
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String accountNumber = "";
			String customerName = "";
			String customerIfsc="";
			String customerAddress="";
			String balance="";
			String status = "";
			Admin customer=null;
			AdminService adminservice = AdminServiceFactory.getAdminService();
			while(true){
				System.out.println("================================================================");
				System.out.println();
				System.out.println("1. Add customer");
				System.out.println("2. Search customer");
				System.out.println("3. update customer");
				System.out.println("4. Delete customer");
				System.out.println("5. Exit");
				System.out.println("your Option : ");
				System.out.println("================================================================");
				int option = Integer.parseInt(br.readLine());
				//String customerAddress;
				switch(option) {
				case 1 :
					System.out.println("================================================================");
					System.out.println("Customer accountNumber : ");
					accountNumber = br.readLine();
					System.out.println("Customer Name          : ");
					customerName = br.readLine();
					System.out.println("Customer  IFSC         : ");
					customerIfsc = br.readLine();
					System.out.println("Customer Address       : ");
					customerAddress = br.readLine();
					System.out.println("Customer Balance       : ");
					balance = br.readLine();
					System.out.println("================================================================");

					
					customer =  new Admin();
					customer.setAccountNumber(accountNumber);
					customer.setCustomerName(customerName);
					customer.setCustomerIfsc(customerIfsc);
					customer.setCustomerAddress(customerAddress);
					customer.setBalance(balance);
					
					status = adminservice.add(customer); 
					if(status.equalsIgnoreCase("success")) {
						System.out.println("status   :  customer added successfully");
					}
					if(status.equalsIgnoreCase("existed")) {
						System.out.println("status   :  customer existed already");
					}
					if(status.equalsIgnoreCase("failure")) {
						System.out.println("status   :  customer insertion failure");
					}
					
					
					break; 
				case 2:
					System.out.print("Customer Id    : ");
					accountNumber = br.readLine();
					customer = adminservice.search(accountNumber);
					if(customer == null) {
						System.out.println("================================================================");
						System.out.println("Status   : Customer Not Existed");
						System.out.println("================================================================");
					}else {
						System.out.println("Status   : Customer Existed");
						System.out.println("Customer Details");
						System.out.println("================================================================");
						System.out.println("Account Number      : "+customer.getAccountNumber());
						System.out.println("Customer Name    : "+customer.getCustomerName());
						System.out.println("Customer IFSC    : "+customer.getCustomerIfsc());						
						System.out.println("Customer Address : "+customer.getCustomerAddress());
						System.out.println("Customer balance : "+customer.getBalance());
						System.out.println("================================================================");

					}
					
				break;
				case 3:
					System.out.print("Account Number    : ");
					accountNumber = br.readLine();
					customer = adminservice.search(accountNumber);
					if(customer == null) {
						System.out.println("Status  : customer Not Existed");
					}else {
						System.out.println("================================================================");
						System.out.print("Customer Name [Old : "+customer.getCustomerName()+"] New : ");
						customerName = br.readLine();
						System.out.print("Customer IFSC [Old : "+customer.getCustomerIfsc()+"] New : ");
						customerIfsc = br.readLine();
						System.out.print("Customer Address [Old : "+customer.getCustomerAddress()+"] New : ");
						customerAddress = br.readLine();
						System.out.println("Customer Balance [Old :"+customer.getBalance()+"] New : ");
						balance=br.readLine();
						System.out.println("================================================================");

						
						Admin newCustomer = new Admin();
						newCustomer.setAccountNumber(accountNumber);
						newCustomer.setCustomerName(customerName);
						newCustomer.setCustomerIfsc(customerIfsc);
						newCustomer.setCustomerAddress(customerAddress);
						newCustomer.setBalance(balance);
						
						status = adminservice.update(newCustomer);
						if(status.equalsIgnoreCase("success")) {
							System.out.println("Status  : Customer Updated Successfully");
						}
						if(status.equalsIgnoreCase("failure")) {
							System.out.println("Status  : Customer Updation Failure");
						}
						
					}
					
				break;
				case 4:
					System.out.print("Account Number    : ");
					accountNumber = br.readLine();
					
					status = adminservice.delete(accountNumber);
					
					if(status.equalsIgnoreCase("success")) {
						System.out.println("Status  : Customer Deleted Successfully");
					}
					if(status.equalsIgnoreCase("failure")) {
						System.out.println("Status  : Customer Deletion Failure");
					}
					if(status.equalsIgnoreCase("notexisted")) {
						System.out.println("Status  : Customer Not Existed");
					}
					
				break;
				case 5:
					System.out.println("================================================================");

					System.out.println("******Thank You for Using Remitter Management System******");
					System.exit(0);
				break;
				default:
					System.out.println("Invalid Option You Selected, Provide the numbers from 1,2,3,4 and 5");
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
