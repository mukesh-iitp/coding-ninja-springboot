package com.codingninjas.Foodies.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	
	@Column
	private double rating;
	
	//many to one
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	@JsonBackReference(value ="restaurant_id")
	private Restaurant restaurant;
	
	@ManyToOne
    @JoinColumn(name = "customer_id")
	@JsonBackReference
    private Customer customer;

	public Rating() {
		super();
	}

	public Rating(int id, double rating, Restaurant restaurant, Customer customer) {
		super();
		this.id = id;
		this.rating = rating;
		this.restaurant = restaurant;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
