package com.codingninjas.Foodies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingninjas.Foodies.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer>{

}
