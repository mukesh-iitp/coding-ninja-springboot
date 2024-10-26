package com.cn.cncart.dal;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cncart.entity.Item;
import com.mysql.cj.jdbc.result.UpdatableResultSet;

import jakarta.persistence.EntityManager;

@Repository
public class ItemDALImpl implements ItemDAL {
	
	@Autowired
	EntityManager entityManager; 

	@Override
	public Item getByID(int id) {
		//fetching session object to interact with database
		Session session = entityManager.unwrap(Session.class);
		Item item = session.get(Item.class, id);
		return item;
	}

	@Override
	public void save(Item item) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(item);
	}

	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		Item item = session.get(Item.class, id);
		//session.delete(item);
		session.remove(item);
	}

	@Override
	public void update(Item updatedItem) {
		Session session = entityManager.unwrap(Session.class);
		
		//fetch the current item details from the database
		Item currentItem = session.get(Item.class, updatedItem.getId());		
		
		//update the details in current object
		currentItem.setDescription(updatedItem.getDescription());
		currentItem.setName(updatedItem.getName());
		
		//update the details in the database
		//session.update(item);
		session.merge(currentItem);
	}
	
	

}
