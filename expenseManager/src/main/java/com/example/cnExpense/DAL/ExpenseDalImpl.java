package com.example.cnExpense.DAL;


import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.ExpenseType;
import com.example.cnExpense.entities.Income;

@Repository
public class ExpenseDalImpl implements ExpenseDal {

	@Autowired
	EntityManager entityManager;

	@Override
	public Income saveExpense(Income income, Expense newExpense) {
		Session session = entityManager.unwrap(Session.class);
		Integer expenseId = (Integer) session.save(newExpense);
		Expense expense = session.get(Expense.class, expenseId);
		income = session.get(Income.class, income.getId());
		income.setExpense(expense);
		session.update(income);
		for (ExpenseType expenseType : newExpense.getExpenseTypes()) {
			expenseType.setExpense(expense);
			session.save(expenseType);
		}
		session.flush();
		return income;
	}

}

