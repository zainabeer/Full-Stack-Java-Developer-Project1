package LockedMe;

import java.util.*;
import java.io.*;

public class cLockedMe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		File theDir = new File("C:\\LockedMe");
		if (!theDir.exists()){ // create the LockedMe if it does not exists for user
		    theDir.mkdirs();
		}
		
		Details del = new Details(); // object  of class Details
		OrderNames orn = new OrderNames(); // object of class OrderNames

		System.out.println("Welcome to LockedMe.com Application");
		System.out.println("");
		System.out.println("Application for you to retrieve, add, delete and search files");
		System.out.println("Dealing with files will be through the LockedMe folder");
		System.out.println("The path of LockedMe folder: C:"+ File.separator+"LockedMe");
		System.out.println("About the developer:");
		System.out.println("Name: Zainab Saleh");
		System.out.println("Email: 217031353@student.kfu.edu.sa");
		System.out.println("Email: z0o0.1419@gmail.com");
		System.out.println("");
		
		int c = 0 ; 
		
		while(c != 3) { // condition to stop the loop when user close the application
			
			System.out.println("Please choose what you want to do:");
			System.out.println("1- Retrieving the file names in an ascending order");
			System.out.println("2- More options (Add, Delete,Search) for files");
			System.out.println("3- Close the application");
			System.out.print("Enter your choice: ");
			
			try {
				
				c = input.nextInt(); // user choice // catch InputMismatchException
				System.out.println("");
				
				switch (c) {
				
				case 1 : // Retrieving
					
					orn.ascendingOrder() ; // call the method from OrderNames class
					System.out.println("");
					break;
					
				case 2 : // Add, Delete,Search
					
					del.opreationdel(); // call the method from Details class
					System.out.println("");
					break;
					
				case 3 : // Close the application
					System.out.println("You have close the application");
					c = 3 ;
					System.out.println("");
					break ;
					
				default : // user enter number not from the options
					System.out.println("Please enter number from the options");
					System.out.println("");
					break ;
				
				}
				
			}
			
			catch (InputMismatchException e) { // catch if user enter String instead of integer
				String bad_input = input.nextLine(); // to handle the wrong input and continue the loop
                System.out.println("\nError! Please Enter a Number");
                System.out.println("");
                c = 0 ;
                continue;
            }
			
		}
		
		System.out.println("Thank you for using our application");
		System.out.println("LockedMe.com");
		
	}

}
