package com.codingNinjas.Bank.Account.Registration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
  This class is an implementation of a User Interface based on the selection 
  done in the console for user information.You need to complete this class 
  based on the following tasks.

   a. Adding common attributes: 
       1. String name
       2. List<Account> accountList.
   b. Override the methods of User Interface.
   c. Build the logic for all the methods based on the description mentioned in the Account Interface.

**/

@Component
public class myUser implements User{
	
	String name;
	List<Account> accountList = new ArrayList<Account>();
	
	
	@PostConstruct
	public void init() {
		System.out.println("init method called");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("distroy method called");
	}
	
	@Override
	public void setUserDetails(String name) {
		this.name = name;
		
	}
	
	@Override
	public void addAccount(Account account) {
		this.accountList.add(account);
		
	}
	@Override
	public List<Account> getAllAccounts() {
		return this.accountList;
	}
	@Override
	public String getName() {
		return this.name;
	}
	
	

}
