package com.codingninjas.Foodies.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Rating> ratings;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Restaurant> visitedRestaurants;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
