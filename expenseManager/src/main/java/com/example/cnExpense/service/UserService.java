package com.example.cnExpense.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cnExpense.DAL.UserDal;
import com.example.cnExpense.entities.User;

@Service
public class UserService {
	
	@Autowired
	UserDal userDal;

	@Transactional
	public List<User> getAllUsers() {
		return userDal.getAllUsers();
	}

	@Transactional
	public User getUserById(Integer id) {
		return userDal.getUserById(id);
	}

	@Transactional
	public User saveUser(User user) {
		return userDal.saveUser(user);
	}

	@Transactional
	public Boolean checkUserExist(User user) {
		return userDal.checkUserExist(user);
	}

	@Transactional
	public User findUser(User newUser) {
		return userDal.findUser(newUser);
	}
	
	/*

	@Transactional
	public List<User> filteredUserListByCalendar(String day, String month, String year) {
		return userDal.filteredUserListByCalendar(day, month, year);
	}

	@Transactional
	public List<User> filteredUserListByType(String incomeType, String expenseType) {
		return userDal.filteredUserListByType(incomeType, expenseType);
	}
	*/
	
	
}
