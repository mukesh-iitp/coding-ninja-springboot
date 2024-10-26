package com.cn.cnEvent.dal;


import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnEvent.entity.Event;

@Repository
public class EventDALImpl implements EventDAL {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Event getById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Event event = session.get(Event.class, id);
		return event;
	}

	@Override
	public List<Event> getAllEvents() {
		Session session = entityManager.unwrap(Session.class);
		List<Event> eventList = session.createQuery(
				"select e from Event e", Event.class).getResultList();
		
		return eventList;
	}

	@Override
	public String save(Event item) {
		Session session = entityManager.unwrap(Session.class);
		session.save(item);
		return "The event was saved successfully.";
	}

	@Override
	public String delete(long id) {
		Session session = entityManager.unwrap(Session.class);
		Event event = session.get(Event.class, id);
		session.delete(event);
		return "The event was deleted successfully";
	}

	@Override
	public String update(Event updatedEvent) {
		Session session = entityManager.unwrap(Session.class);
		Event currentEvent = session.get(Event.class, updatedEvent.getId());
		currentEvent.setName(updatedEvent.getName());
		currentEvent.setDescription(updatedEvent.getDescription());
		session.save(currentEvent);
		return "Event is updated successfully";
	}

}
