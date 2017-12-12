package com.hurricane.future.blog.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
@Repository
public class TopicDAO {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
