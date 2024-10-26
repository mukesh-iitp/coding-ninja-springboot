 package com.cn.cnpayment.dal;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnpayment.entity.Orders;
import com.cn.cnpayment.entity.Payment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Order;


/**
  Complete the OrderDalImpl implementation class as mentioned below:
  
    a. Autowire EntityManager.

    b. Override the following methods:

      1. getById(int id): This method fetches an Order from the database for a specific Id.

      2. save(Orders order): This method saves an Order into the database.

      3. delete(int id): This method deletes an Order from the database for a specific Id.

      4. getAllOrders(): This method fetches the list of Orders from the database.
**/

@Repository
public class OrderDalImpl implements OrderDal
{
    //Autowire the EntityManager object.
	@Autowired
	EntityManager entityManager;

	@Override
	public Orders getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Orders order = session.get(Orders.class, id);
		return order;
	}

	@Override
	public void save(Orders order) {
		Session session = entityManager.unwrap(Session.class);
		session.save(order);
	}

	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		Orders order = session.get(Orders.class, id);
		session.delete(order);
	}

	@Override
	public List<Orders> getAllOrders() {
		Session session = entityManager.unwrap(Session.class);
		List<Orders> orderList = session.createQuery(
				"SELECT o FROM Orders o", Orders.class).getResultList();
		return orderList;
	}
	
	
	

}
