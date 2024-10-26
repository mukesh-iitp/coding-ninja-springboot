package com.codingNinjas.PaymentService;

public class PayPalPaymentService implements PaymentService {

	public void processPayment(double amount) {
		System.out.println("Processing PayPal payment of $" + amount);
	}

}
