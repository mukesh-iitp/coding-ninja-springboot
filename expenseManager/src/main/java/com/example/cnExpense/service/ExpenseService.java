package com.example.cnExpense.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cnExpense.DAL.ExpenseDal;
import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;

@Service
public class ExpenseService {
	
	@Autowired
	ExpenseDal expenseDal;

	@Transactional
	public Income saveExpense(Income income, Expense expense) {
		return expenseDal.saveExpense(income,expense);
	}
	
	

}
