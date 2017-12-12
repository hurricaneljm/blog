package com.hurricane.future.blog.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hurricane.future.blog.domain.User;
@Repository
public class IndexDAO {
	
	private SessionFactory sessionFactory;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save() {
		System.out.println("开始执行save方法");
		new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		System.out.println(session.isJoinedToTransaction());
		User user = new User();
		user.setUserName("hurricane");
		session.save(user);
		System.out.println("结束执行save方法");
	}
}
