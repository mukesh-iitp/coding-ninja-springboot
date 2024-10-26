package com.cn.cncart.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_details")
public class ItemDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	
	@Column
	private String brand;
	
	@Column
	private double price;
	
	@Column
	private String category;
	
	@OneToOne(mappedBy = "itemDetails", cascade = CascadeType.ALL)
	private Item item;

	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
