package com.codingninjas.Foodies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codingninjas.Foodies.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

	@Query(value = "SELECT AVG(r.rating) FROM Rating r WHERE r.restaurant.name =?1")
	Double findAverageRatingByRestaurantName(String restaurantName);

}
