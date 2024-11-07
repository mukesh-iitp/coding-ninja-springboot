package com.codingninjas.Foodies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Restaurant;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	List<Customer> findByVisitedRestaurants(Restaurant restaurant);

	@Query("SELECT DISTINCT c FROM Customer c JOIN c.visitedRestaurants r JOIN c.ratings ra WHERE r.name =?1 AND ra.rating >?2")
	List<Customer> getCustomersWhoRatedResturantGreater(String restaurantName, double rating);
}
