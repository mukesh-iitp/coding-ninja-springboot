package com.codingNinjas.PaymentService;

public class CreditCardPaymentService implements PaymentService {

	public void processPayment(double amount) {
		System.out.println("Processing credit card payment of $" + amount);
	}

}
