package com.CodingNinjas.TaxEase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CodingNinjas.TaxEase.model.User;

// 1. Add the required annotation over UserRepository.
// 2. Extent the UserRepository with JpaRepository
public interface UserRepository extends JpaRepository<User, Long>{
	
	
}
