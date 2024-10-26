package com.example.cnExpense.DAL;

import java.util.List;

import com.example.cnExpense.entities.User;

public interface UserDal {

	List<User> getAllUsers();

	User getUserById(Integer id);

	User saveUser(User user);

	Boolean checkUserExist(User user);

	User findUser(User newUser);

	//List<User> filteredUserListByCalendar(String day, String month, String year);

	//List<User> filteredUserListByType(String incomeType, String expenseType);

}
