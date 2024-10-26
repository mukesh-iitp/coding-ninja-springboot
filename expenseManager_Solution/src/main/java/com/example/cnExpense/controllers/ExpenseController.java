package com.example.cnExpense.controllers;

import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/save/{incomeId}")
    @ResponseBody
    public Income saveExpense(@PathVariable Integer incomeId, @RequestBody Expense expense) {
        Income income=new Income();
        income.setId(incomeId);
        return expenseService.saveExpense(income, expense);
    }
}
