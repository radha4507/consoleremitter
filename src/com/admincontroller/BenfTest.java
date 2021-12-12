package com.admincontroller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.admindto.Benf;
import com.adminfactory.BenfServiceFactory;
import com.adminservice.BenfService;

public class BenfTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		System.out.println("Beneficiary Operation System");
		System.out.println("================================================================");
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String beneficiaryNumber = "";
			String beneficiaryName = "";
			String accountNumber="";
			String beneficiaryIfsc="";
			String branchName="";
			String status = "";
			Benf beneficiary=null;
			BenfService beneficiaryservice = BenfServiceFactory.getBenfService();
			while(true){
				System.out.println("================================================================");
				System.out.println();
				System.out.println("1. Add Beneficiary");
				System.out.println("2. Search Beneficiary");
				System.out.println("3. update Beneficiary");
				System.out.println("4. Delete Beneficiary");
				System.out.println("5. Exit");
				System.out.println("your Option : ");
				System.out.println("================================================================");
				int option = Integer.parseInt(br.readLine());
				switch(option) {
				case 1 :
					System.out.println("================================================================");
					System.out.println("Beneficiary Number : ");
					beneficiaryNumber = br.readLine();
					System.out.println("Beneficiary Name          : ");
					beneficiaryName = br.readLine();
					System.out.println("Beneficiary  AccountNumber         : ");
					accountNumber = br.readLine();
					System.out.println("Benificiary Ifsc       : ");
					beneficiaryIfsc = br.readLine();
					System.out.println("Branch Name      : ");
					branchName = br.readLine();
					System.out.println("================================================================");

					
					beneficiary =  new Benf();
					 beneficiary.setBeneficiaryNumber(beneficiaryNumber);
					 beneficiary.setBeneficiaryName(beneficiaryName);
					 beneficiary.setAccountNumber(accountNumber);
					 beneficiary.setBeneficiaryIfsc(beneficiaryIfsc);
					 beneficiary.setBranchName(branchName);
					
					status = beneficiaryservice.add(beneficiary); 
					if(status.equalsIgnoreCase("success")) {
						System.out.println("status   :  beneficiary added successfully");
					}
					if(status.equalsIgnoreCase("existed")) {
						System.out.println("status   :  beneficiary existed already");
					}
					if(status.equalsIgnoreCase("failure")) {
						System.out.println("status   :  beneficiary insertion failure");
					}
					
					
				break; 
				case 2:
					System.out.print("Beneficiary Id    : ");
					beneficiaryNumber = br.readLine();
					beneficiary = beneficiaryservice.search(beneficiaryNumber);
					if(beneficiary == null) {
						System.out.println("================================================================");
						System.out.println("Status   : Beneficiary Not Existed");
						System.out.println("================================================================");
					}else {
						System.out.println("Status   : Beneficiary Existed");
						System.out.println("Beneficiary Details");
						System.out.println("================================================================");
						System.out.println("Beneficiary Number      : "+beneficiary.getBeneficiaryNumber());
						System.out.println("Beneficiary Name    : "+beneficiary.getBeneficiaryName());
						System.out.println("Beneficiary AccountNumber : "+beneficiary.getAccountNumber());
						System.out.println("Beneficiary IFSC    : "+beneficiary.getBeneficiaryIfsc());						
						System.out.println("Beneficiary branch : "+beneficiary.getBranchName());
						System.out.println("================================================================");

					}
					
				break;
				case 3:
					System.out.print("Benenficiary ID    : ");
					beneficiaryNumber = br.readLine();
					beneficiary = beneficiaryservice.search(beneficiaryNumber);
					if(beneficiary == null) {
						System.out.println("Status  : Beneficiary Not Existed");
					}else {
						System.out.println("================================================================");
						
						System.out.print("Beneficiary Name [Old : "+beneficiary.getBeneficiaryName()+"] New : ");
						beneficiaryName = br.readLine();
						System.out.print("Beneficiary ACCNO [Old : "+beneficiary.getAccountNumber()+"] New : ");
						accountNumber = br.readLine();
						System.out.print("Beneficiary IFSC [Old : "+beneficiary.getBeneficiaryIfsc()+"] New : ");
						beneficiaryIfsc= br.readLine();
						System.out.println("Beneficiary Branch [Old :"+beneficiary.getBranchName()+"] New : ");
						branchName = br.readLine();
						System.out.println("================================================================");

						
						Benf newBeneficiary = new Benf();
						newBeneficiary.setBeneficiaryNumber(beneficiaryNumber);
						newBeneficiary.setBeneficiaryName(beneficiaryName);
						newBeneficiary.setAccountNumber(accountNumber);
						newBeneficiary.setBeneficiaryIfsc(beneficiaryIfsc);
						newBeneficiary.setBranchName(branchName);
						
						status = beneficiaryservice.update(newBeneficiary);
						if(status.equalsIgnoreCase("success")) {
							System.out.println("Status  : beneficiary Updated Successfully");
						}
						if(status.equalsIgnoreCase("failure")) {
							System.out.println("Status  : beneficiary Updation Failure");
						}
						
					}
					
				break;
				case 4:
					System.out.print("Benenficiary Number    : ");
					beneficiaryNumber = br.readLine();
					
					status = beneficiaryservice.delete(beneficiaryNumber);
					
					if(status.equalsIgnoreCase("success")) {
						System.out.println("Status  : Beneficiary Deleted Successfully");
					}
					if(status.equalsIgnoreCase("failure")) {
						System.out.println("Status  : Beneficiary Deletion Failure");
					}
					if(status.equalsIgnoreCase("notexisted")) {
						System.out.println("Status  : Beneficiary Not Existed");
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
