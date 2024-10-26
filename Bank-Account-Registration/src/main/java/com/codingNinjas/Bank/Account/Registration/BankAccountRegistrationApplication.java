package com.codingNinjas.Bank.Account.Registration;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class BankAccountRegistrationApplication {

	public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.
		
		* 1. Fetch context from ApplicationContext.xml and initiate scanner.
		* 2. Get user details from console.
		* 3. Get account details from user and add them to the account list.
		* 4. Display the list of accounts with their reference ids.
		*/
		
		ApplicationContext context = SpringApplication.run(BankAccountRegistrationApplication.class, args);
		
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.codingNinjas.Bank.Account.Registration");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to Account Registration Application!");
		//User myUser = (User) context.getBean("myUser");
		User myUser = context.getBean(User.class);
		
		
		System.out.println("Please enter your name?");
		String userName = scanner.nextLine();
		myUser.setUserDetails(userName);
		
		while(true) {
			System.out.println("Do you want to add account\n1. Yes\n2. No");
			int userChoice = scanner.nextInt();
			
			
			if(userChoice == 1) {
				while(true) {
					System.out.println("Please select account type\n1. Current\n2. Savings");
					int accountTypeChoice = scanner.nextInt();
					
					//String accountType ="";
					Account account = null;
					
					switch (accountTypeChoice) {
					case 1:
						//accountType = "currentAccount";
						account = context.getBean(currentAccount.class);
						break;
					case 2:
						//accountType = "savingsAccount";
						account = context.getBean(savingsAccount.class);
						break;
					
					default:
						System.out.println("Select valid account type");
					}
					
					//Account account = (Account) context.getBean(accountType);
					//Account account = context.getBean(Account.class);
					
					System.out.println("Enter the opening balance");
					double balance = scanner.nextDouble();
					account.addBalance(balance);
					myUser.addAccount(account); //my mistake
					
					System.out.println("Do you want to add more accounts\n1. Yes\n2. No");
					int moreAccChoice = scanner.nextInt();
					if(moreAccChoice==2) {
						System.out.println("Exiting this section...");
						break;	
					}
				}

			}
			else if(userChoice == 2){
				System.out.println("Exiting...");
				break;
			}
			else {
				System.out.println("Enter valid input");
			}

			
		}
		System.out.println("Hi " + myUser.getName() +", here is the list of your accounts:");
		for(Account account : myUser.getAllAccounts()){
			System.out.println(account.getAccountType() + " : opening balance - " + account.getBalance() + " Reference Id " + account.toString().substring(57 , 66));
		}//my mistake
		
		scanner.close();
		//context.close();

	}

}
