package com.hurricane.future.blog.test;

import javax.transaction.TransactionManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.hurricane.future.blog.dao.IndexDAO;
import com.hurricane.future.blog.domain.Topic;
import com.hurricane.future.blog.domain.User;
public class TestSpringHibernate {

	@Test
	public void 打印() {
		System.out.println("中文方法");
		int a=-6;
		for (int i = 0; i < 32; i++) {
			int t = (a&(0x80000000>>>i))>>>(31-i);
			System.out.println(t);
		}
		System.out.println(0xff>>2);
		System.out.println(0xff>>>2);//>>与>>>的区别
	}
	
	
	
	@Test
	public void testTransaction() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		try {
			IndexDAO dao = context.getBean(IndexDAO.class);
			dao.save();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("关闭上下文");
		context.close();
	}
}
