package com.codingNinjas.Bank.Account.Registration;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

/**
  This class is an implementation of a "Account" Interface based on the selection 
  done in the console for account type. You need to complete this class
  based on the following tasks.

     Tasks:
   a. Create attribute amount(double) 
   b. Override the methods of Account Interface.
   c. Build the logic for all the methods based on the description mentioned in the Account Interface.

**/

@Component("savingsAccount")
@Scope("prototype")
public class savingsAccount implements Account{
	
	double amount;
	
	@PostConstruct
    public void init() {
        System.out.println("Savings Account has been created I'm the init() method");
    }


	@Override
	public String getAccountType() {
		return "Saving Account";
	}

	@Override
	public void addBalance(double balance) {
		this.amount = this.amount + balance;
		
	}

	@Override
	public double getBalance() {
		return this.amount;
	}

}
