package com.admincontroller;

import java.util.Scanner;


public class Main {

	public static void main(String[] args)   {
	
		System.out.println("================================================================");
		System.out.println("WELCOME TO REMITTER MANAGEMENT SYSTEM");
		System.out.println("================================================================");
		System.out.println("your logging as ADMIN/REMITTER ???? ");
		System.out.println("================================================================");
		Scanner sc = new Scanner(System.in);
		String role = sc.nextLine();
		
			
		
		
			System.out.println("================================================================");
			System.out.println("enter username :");
			String user = sc.nextLine();
			System.out.println("enter password :");
			String pass = sc.nextLine();
			
			if(user.equals("admin") && pass.equals("admin") && role.equals("admin")) {
				Test.main(args);
			}
			else if(user.equals("remitter") && pass.equals("remitter") && role.equals("remitter")) {
				RemTest.main(args);
	
			}
			else {
				System.out.println("================================================================");
				System.out.println("Wrong Details Entered Try Again");
				System.out.println("================================================================");
				Main.main(args);
			}
			sc.close();
		}
		
	
	
}
	


