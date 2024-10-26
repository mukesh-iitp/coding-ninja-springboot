package com.example.cnExpense.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "income")
public class Income {

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

	//one to one mapping
	@OneToOne//(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Expense expense;

	//many to many mapping
	@ManyToMany(mappedBy = "incomes")
	@JsonBackReference
	@JsonIgnore
	private List<User> users;

	//one to many mapping
	@OneToMany(mappedBy = "income",  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JsonManagedReference
	@JsonIgnore
	private List<IncomeType> incomeTypes;

	public Income() {
		super();
		users=new ArrayList<>();
	}

	public Income(int id, double amount, LocalDate date, String description, Expense expense, List<User> users,
			List<IncomeType> incomeTypes) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.expense = expense;
		this.users = users;
		this.incomeTypes = incomeTypes;
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

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<IncomeType> getIncomeTypes() {
		return incomeTypes;
	}

	public void setIncomeTypes(List<IncomeType> incomeTypes) {
		this.incomeTypes = incomeTypes;
	}




}
