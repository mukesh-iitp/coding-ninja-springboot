package com.codingninjas.Foodies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Rating;
import com.codingninjas.Foodies.entity.Restaurant;
import com.codingninjas.Foodies.repository.CustomerRepository;
import com.codingninjas.Foodies.repository.RatingRepository;
import com.codingninjas.Foodies.repository.RestaurantRepository;

@Service
public class MainService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	RatingRepository ratingRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	

	public Restaurant addRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Rating addRating(Rating rating, Integer customerId, String restaurantName) {
		Customer customer = customerRepository.findById(customerId).orElseThrow(
				()->new RuntimeException("customer not found"));
		Restaurant restaurant = restaurantRepository.findByName(restaurantName);
		rating.setCustomer(customer);
		rating.setRestaurant(restaurant);
		return ratingRepository.save(rating);
	}

	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

}
