package com.hurricane.future.blog.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hurricane.future.blog.dao.IndexDAO;
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
