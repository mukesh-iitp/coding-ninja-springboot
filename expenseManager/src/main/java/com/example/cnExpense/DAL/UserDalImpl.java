package com.example.cnExpense.DAL;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cnExpense.entities.User;


@Repository
public class UserDalImpl implements UserDal {

	@Autowired
	EntityManager entityManager;
	

	@Override
	public List<User> getAllUsers() {
		Session session = entityManager.unwrap(Session.class);
		List<User> allUsers = session.createQuery("Select u From User u", User.class)
				.getResultList();
		return allUsers;
	}

	@Override
	public User getUserById(Integer id) {
		Session session = entityManager.unwrap(Session.class);
		User user = session.get(User.class, id);
		return user;
	}

	@Override
	public User saveUser(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.save(user);
		return user;
	}

	@Override
	public Boolean checkUserExist(User user) {
		/*
		Session session = entityManager.unwrap(Session.class);
		User dbUser = session.get(User.class, user.getId());
		if(dbUser.equals(user))
			return true;
		else
			return false;
		 */
		boolean userExist=false;
		for (User everyUser: getAllUsers()) {
			if (everyUser.getUsername().equalsIgnoreCase(user.getUsername())) {
				userExist = true;
			}
		}
		return userExist;
	}

	@Override
	public User findUser(User newUser) {
		/*
		Session session = entityManager.unwrap(Session.class);
		User dbUser = session.get(User.class, newUser.getId());
		if(dbUser.equals(newUser))
			return dbUser;
		else
			return null;
		 */
		//Session session = entityManager.unwrap(Session.class);
		for(User user:getAllUsers())
		{
			if(user.getUsername()!=null && user.getUsername().equalsIgnoreCase(newUser.getUsername()))
			{
				return user;
			}
		}
		return null;
	}

	/*
	@Override
	public List<User> filteredUserListByCalendar(String day, String month, String year) {
		List<User> allUsers = getAllUsers();
		List<User> filterdUsers = new ArrayList<User>();

		for(User user : allUsers) {
			List<Income> allIncome = user.getIncomes();
			for(Income income : allIncome) {

			}
		}

		return null;
	}

	@Override
	public List<User> filteredUserListByType(String incomeType, String expenseType) {
		List<User> allUsers = getAllUsers();
		List<User> filterdUsers = new ArrayList<User>();

		for(User user : allUsers) {

		}
		return null;
	}
	 */

}
