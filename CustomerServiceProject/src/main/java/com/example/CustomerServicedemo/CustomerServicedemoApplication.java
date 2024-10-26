package com.example.CustomerServicedemo;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.Customers.CustomerCare;

@SpringBootApplication
public class CustomerServicedemoApplication {

	public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

			 Tasks:
		 *  1. Load the beans from ApplicationContext.xml
		 *  2. Display all the departments available and get the input from user.
		 *  3. Get the message from user and store it into the respective department.
		 *  
		 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerCare customerCare = null;
		String service = null;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to our Customer Care application ");
		System.out.print("Please enter your name: ");
		String customerName = scanner.nextLine();

		System.out.println("Thanks for reaching us " + customerName);
		System.out.println("Please select a department to connect to:");
		System.out.println("1. Payment Department");
		System.out.println("2. Query Department");
		System.out.println("3. Sales Department");
		System.out.println("0. Exit");

		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		if (choice >= 0 && choice < 4) {
			switch (choice) {

			case 1:
				service = "paymentDepartment";
				break;
			case 2:
				service = "queryDepartment";
				break;
			case 3:
				service = "salesDepartment";
				break;

			default:
				System.out.println("You have exited the application.");
			}
			// getting the implemented services
			customerCare = (CustomerCare) context.getBean(service);
			customerCare.setCustomerName(customerName);
			customerCare.getService();

			String Issue = scanner.nextLine();
			customerCare.setProblem(Issue);
			customerCare.getProblem();

		}

		else {
			System.out.println(
					"You have given an wrong Input would you like to continue using the Customer Care application? y/n");
			String wanttoContinue = scanner.nextLine(); // Consume the newline character
			System.out.println(wanttoContinue);
			if (wanttoContinue.toLowerCase().equals("y")) {
				System.out.println("entered loop");
				main(null);
			} else {
				System.out.println("You have exited the Application");

			}
			

		}
		scanner.close();
		context.close();
	}

}
