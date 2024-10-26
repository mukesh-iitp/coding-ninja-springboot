package com.infinity.carDealership;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infinity.cars.Car;

@SpringBootApplication
public class CarDealershipApplication {

	public static void main(String[] args) {
		
		//SpringApplication.run(CarDealershipApplication.class, args);
		
		String carChoice = null;
		
		Scanner sc = new Scanner(System.in);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println("Hi, please enter your name.");
		String username = sc.next();
		
		System.out.println("Please select your car of choice:"
				+"\n1. family car"
				+"\n2. sports car"
				+"\n3. truck"
				+"\n4. exit");
		int choice = sc.nextInt();
		int tyreType;
		
		if (choice >= 0 && choice <= 4) {
			switch (choice) {
			
			case 1:
				//take input of tyre type
				System.out.println("Please enter tyre type: "
						+ "\n1. Normal Tyre "
						+ "\n2. Sports Tyre");
				tyreType = sc.nextInt();
				switch (tyreType) {
				case 1:
					carChoice = "familyCarNormalTyre";
					break;
				case 2:
					carChoice = "familyCarSportsTyre";
					break;
				default:
					System.out.println("Error...");
				}
				//carChoice = "familyCar";
				break;
			case 2:
				//carChoice = "sportsCar";
				System.out.println("Please enter tyre type: "
						+ "\n1. Sports Tyre "
						+ "\n2. Heavy Tyre");
				tyreType = sc.nextInt();
				switch (tyreType) {
				case 1:
					carChoice = "sportsCarSportsTyre";
					break;
				case 2:
					carChoice = "sportsCarHeavyTyre";
					break;
				default:
					System.out.println("Error...");
				}
				break;
			case 3:
				carChoice = "truck";
				break;

			default:
				System.out.println("You have exited the application.");
				return;
			}
			
			Car car = (Car) context.getBean(carChoice);
			System.out.println(username+" owns "+ car.getInfo());
		}
		
		else {
			return;
		}
		

		
	}

}	
