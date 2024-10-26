package com.example.cnExpense.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cnExpense.DAL.IncomeDal;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.User;

@Service
public class IncomeService {
	
	@Autowired
	IncomeDal incomeDal;

	@Transactional
	public Income getIncomeById(int incomeid) {
		return incomeDal.getIncomeById(incomeid);
	}

	@Transactional
	public Income saveIncome(User user, Income income) {
		return incomeDal.saveIncome(user,income);
	}
	
	

}
