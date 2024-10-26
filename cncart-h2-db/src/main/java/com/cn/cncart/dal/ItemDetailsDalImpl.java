package com.cn.cncart.dal;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cncart.entity.ItemDetails;

import jakarta.persistence.EntityManager;

@Repository
public class ItemDetailsDalImpl implements ItemDetailsDal {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public void delete(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		ItemDetails itemDetails = session.get(ItemDetails.class, id);
		//session.delete(itemDetails);	//deprecated method
		session.remove(itemDetails);
		
	}
	

}
