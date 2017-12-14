package com.hurricane.future.blog.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hurricane.future.blog.domain.Category;
import com.hurricane.future.blog.domain.User;

@Repository
public class CategoryDAO {
	private SessionFactory sessionFactory;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Set<Category> getCategoryByUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		if (user==null||user.getId()<=0) {
			return null;
		}
		User user2 = (User) session.createQuery("User u where u.id=:id").setParameter("id", user.getId()).getSingleResult();
		Set<Category> collect = user2.getCategories();
		return collect;
	}
	
}
