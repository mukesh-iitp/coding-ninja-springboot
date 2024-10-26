package com.example.cnExpense.service;

import com.example.cnExpense.DAL.ExpenseDal;
import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseDal expenseDal;

    @Transactional
    public Income saveExpense(Income income, Expense expense) {
        return expenseDal.saveExpense(income,expense);
    }
}