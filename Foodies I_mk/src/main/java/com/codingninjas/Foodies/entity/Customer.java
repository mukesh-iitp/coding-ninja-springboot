package com.codingninjas.Foodies.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	
	@Column
	private String name;
	
	//one to many mapping
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Rating> ratings;
	
	//many to many mapping
	//@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.MERGE})
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "customer_restaurant",
			joinColumns = @JoinColumn(name = "customer_id"),
			inverseJoinColumns = @JoinColumn(name = "restaurant_id")
			)
	private List<Restaurant> visitedRestaurants;

	public Customer() {
		super();
	}

	public Customer(int id, String name, List<Rating> ratings, List<Restaurant> visitedRestaurants) {
		super();
		this.id = id;
		this.name = name;
		this.ratings = ratings;
		this.visitedRestaurants = visitedRestaurants;
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

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Restaurant> getVisitedRestaurants() {
		return visitedRestaurants;
	}

	public void setVisitedRestaurants(List<Restaurant> visitedRestaurants) {
		this.visitedRestaurants = visitedRestaurants;
	}
		

}
