package com.codingninjas.Foodies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Rating;
import com.codingninjas.Foodies.entity.Restaurant;
import com.codingninjas.Foodies.service.MainService;

@RestController
@RequestMapping
public class MainController {

	@Autowired
	private MainService mainService;

	@PostMapping("/Restaurant/add")
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
		return mainService.addRestaurant(restaurant);
	}

	@PostMapping("/Customer/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		return mainService.addCustomer(customer);
	}

	@PostMapping("/Rating/{customerId}/add/{restaurantName}")
	public Rating addRating(@RequestBody Rating rating, @PathVariable Integer customerId, @PathVariable String restaurantName) {
		return mainService.addRating(rating, customerId, restaurantName);
	}

	@GetMapping("/ratings")
	public List<Rating> getAllRatings() {
		return mainService.getAllRatings();
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return mainService.getAllCustomers();
	}

}

