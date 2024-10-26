package com.cn.cncart.dal;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cncart.entity.Order;

import jakarta.persistence.EntityManager;

@Repository
public class OrderDalImpl implements OrderDAL {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Order getOrderById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Order order = session.get(Order.class, id);	
		return order;
	}


	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		Order order = session.get(Order.class, id);	
		session.delete(order);
	}
	
	@Override
	public void save(Order saveOrder) {
		Session session = entityManager.unwrap(Session.class);
		session.save(saveOrder);
	}

}
