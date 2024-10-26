package com.codingNinjas.PaymentService;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class PaymentServiceApplication {

	public static void main(String[] args) throws Exception {
			
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		    
			Scanner scanner = new Scanner(System.in);
	
		        System.out.println("Enter payment amount:");
		        double amount = Double.parseDouble(scanner.nextLine());
		        
		        System.out.println("Enter payment method (CreditCard, PayPal, or BankTransfer):");
		        String paymentMethod = scanner.nextLine();
		        
		        PaymentService paymentService = (PaymentService) context.getBean(paymentMethod+"PaymentService");
		        paymentService.processPayment(amount);

	}

}
