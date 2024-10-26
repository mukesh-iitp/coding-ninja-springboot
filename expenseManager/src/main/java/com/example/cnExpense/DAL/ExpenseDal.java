package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;

public interface ExpenseDal {

	Income saveExpense(Income income, Expense newExpense);

}
