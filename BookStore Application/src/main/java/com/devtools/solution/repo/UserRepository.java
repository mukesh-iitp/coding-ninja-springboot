package com.devtools.solution.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devtools.solution.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
