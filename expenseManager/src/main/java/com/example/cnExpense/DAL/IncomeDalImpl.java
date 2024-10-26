package com.example.cnExpense.DAL;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.IncomeType;
import com.example.cnExpense.entities.User;
import com.example.cnExpense.service.UserService;

@Repository
public class IncomeDalImpl implements IncomeDal {

	@Autowired
	EntityManager entityManager;

	@Autowired
	UserService userService;

	@Override
	public Income getIncomeById(int incomeid) {
		Session session = entityManager.unwrap(Session.class);
		Income income = session.get(Income.class, incomeid);
		return income;
	}

	@Override
	public Income saveIncome(User user, Income newIncome) {
		Session session = entityManager.unwrap(Session.class);
		Income income = new Income();
		income.setAmount(newIncome.getAmount());
		income.setDate(newIncome.getDate());
		income.setDescription(newIncome.getDescription());
		session.save(income);
		for(IncomeType incomeType: newIncome.getIncomeTypes())
		{
			IncomeType newIncomeType=new IncomeType();
			newIncomeType.setName(incomeType.getName());
			newIncomeType.setIncome(income);
			session.save(newIncomeType);
		}
		User newUser=userService.getUserById(user.getId());
		newUser.getIncomes().add(income);
		income.getUsers().add(user);
		session.saveOrUpdate(income);
		session.saveOrUpdate(newUser);
		return income;
	}
}

