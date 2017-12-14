package com.hurricane.future.blog.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hurricane.future.blog.domain.Category;

public class TestDAO {

	@Test
	public void testCircle() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Category category = new Category();
		category.setDescription("描述");
		category.setName("java");
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
}
