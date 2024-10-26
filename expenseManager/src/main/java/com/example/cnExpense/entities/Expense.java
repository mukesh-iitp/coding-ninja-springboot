package com.example.cnExpense.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "expense")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

	@Column
	private double amount;

	@Column
	private LocalDate date;

	@Column
	private String description;

	//many to one mapping
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	//one to one mapping
	@OneToOne(mappedBy = "expense")//(mappedBy = "expense", cascade = CascadeType.ALL)
	@JsonBackReference
	private Income income;

	//one to many mapping
	@OneToMany(mappedBy = "expense", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JsonManagedReference
	private List<ExpenseType> expenseTypes;

	public Expense() {
		super();
	}

	public Expense(int id, double amount, LocalDate date, String description, User user, Income income,
			List<ExpenseType> expenseTypes) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.user = user;
		this.income = income;
		this.expenseTypes = expenseTypes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	public List<ExpenseType> getExpenseTypes() {
		return expenseTypes;
	}

	public void setExpenseTypes(List<ExpenseType> expenseTypes) {
		this.expenseTypes = expenseTypes;
	}




}
