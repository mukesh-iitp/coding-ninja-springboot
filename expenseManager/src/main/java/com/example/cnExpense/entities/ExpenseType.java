package com.example.cnExpense.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "expense_type")
public class ExpenseType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

	@Column
	private String name;

	//many to one mapping
	@ManyToOne
	@JoinColumn(name = "expense_id")
	@JsonBackReference
	private Expense expense;

	public ExpenseType() {
		super();
	}

	public ExpenseType(int id, String name, Expense expense) {
		super();
		this.id = id;
		this.name = name;
		this.expense = expense;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}



}
