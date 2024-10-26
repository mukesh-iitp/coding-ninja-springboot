package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.User;

public interface IncomeDal {

    public Income getIncomeById(Integer incomeid);

    public Income saveIncome(User user,Income income);

}