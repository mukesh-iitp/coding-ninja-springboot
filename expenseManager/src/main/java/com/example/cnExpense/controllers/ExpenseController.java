package com.example.cnExpense.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;

	@PostMapping("/save/{incomeId}")
	@ResponseBody
	public Income saveExpense(@PathVariable Integer incomeId,
			@RequestBody Expense expense) {
		Income income=new Income();
		income.setId(incomeId);
		return expenseService.saveExpense(income, expense);
	}

}
