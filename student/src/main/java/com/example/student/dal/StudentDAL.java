package com.example.student.dal;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.student.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
public class StudentDAL {
	
	@Autowired
	EntityManager entityManager;
	
	public void save(Student student) {
		
		//Get the Session object
		Session session = entityManager.unwrap(Session.class);
		session.save(student);
		
	}

}
