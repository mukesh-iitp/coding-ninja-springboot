package com.codingninjas.Foodies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingninjas.Foodies.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
