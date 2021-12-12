package com.admincontroller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.admindto.Fund;
import com.adminfactory.FundServiceFactory;
import com.adminservice.FundService;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FundTest {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date=new Date();
		BufferedReader br = null;
		System.out.println("Fund Transfer System");
		System.out.println("================================================================");
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String accountNumber = "";
			String customerName = "";
			String customerIfsc="";
			String customerAddress="";
			String balance="";
			String status = "";
			Fund customer=null;
			FundService adminservice = FundServiceFactory.getFundService();
			while(true){
				System.out.println("================================================================");
				System.out.println();
				System.out.println("1. Transfer Fund");
				System.out.println("2. Search Transaction");
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
					System.out.println("Branch Name       : ");
					customerAddress = br.readLine();
					System.out.println("Amount       : ");
					balance = br.readLine();
					System.out.println("================================================================");

					
					customer =  new Fund();
					customer.setAccountNumber(accountNumber);
					customer.setCustomerName(customerName);
					customer.setCustomerIfsc(customerIfsc);
					customer.setCustomerAddress(customerAddress);
					customer.setBalance(balance);
					
					status = adminservice.add(customer); 
					if(status.equalsIgnoreCase("success")) {
						System.out.println("status   :  Transaction successfully :"+sdf.format(date));
					}
					if(status.equalsIgnoreCase("existed")) {
						System.out.println("status   :   Transaction successfull :"+sdf.format(date));
						
					}
					if(status.equalsIgnoreCase("failure")) {
						System.out.println("status   :  Transaction failure");
					}
					
					
					break; 
				case 2:
					System.out.print("Customer Account number    : ");
					accountNumber = br.readLine();
					customer = adminservice.search(accountNumber);
					if(customer == null) {
						System.out.println("================================================================");
						System.out.println("Status   : Transaction Not Existed");
						System.out.println("================================================================");
					}else {
						System.out.println("Status   : Transaction Existed");
						System.out.println("transaction Details");
						System.out.println("================================================================");
						System.out.println("Account Number      : "+customer.getAccountNumber());
						System.out.println("Customer Name    : "+customer.getCustomerName());
						System.out.println("Customer IFSC    : "+customer.getCustomerIfsc());						
						System.out.println("Customer Branch : "+customer.getCustomerAddress());
						System.out.println("Transaction Amount : "+customer.getBalance());
						System.out.println("================================================================");

					}
					
				
					
				break;
				
					
				case 3:
					System.out.println("================================================================");

					System.out.println("******Thank You for Using Remitter Management System******");
					System.exit(0);
				break;
				default:
					System.out.println("Invalid Option You Selected, Provide the numbers from 1,2 and 3");
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

