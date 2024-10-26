package com.codingNinjas.PaymentService;

public class BankTransferPaymentService implements PaymentService {

	public void processPayment(double amount) {
		System.out.println("Processing bank transfer payment of $" + amount);
	}

}
