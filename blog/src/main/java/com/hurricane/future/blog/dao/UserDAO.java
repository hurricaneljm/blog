package com.hurricane.future.blog.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hurricane.future.blog.domain.User;
@Repository
public class UserDAO {

	private SessionFactory sessionFactory;
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}
}
