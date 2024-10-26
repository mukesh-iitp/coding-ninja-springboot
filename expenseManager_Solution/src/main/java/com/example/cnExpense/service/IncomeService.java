package com.example.cnExpense.service;

import com.example.cnExpense.DAL.IncomeDal;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IncomeService {
    @Autowired
    private IncomeDal incomeDal;

    @Transactional
    public Income getIncomeById(Integer incomeid) {
        return incomeDal.getIncomeById(incomeid);
    }

    @Transactional
    public Income saveIncome(User user,Income income) {
        return incomeDal.saveIncome(user,income);
    }
}