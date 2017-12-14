package com.hurricane.future.blog.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurricane.future.blog.domain.Category;
import com.hurricane.future.blog.domain.User;
import com.sun.org.apache.regexp.internal.recompile;

@Service
public class CategoryService {
	private CategoryDAO categoryDAO;
	@Autowired
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	public Set<Category> getCategoryByUser(User user) {
		return categoryDAO.getCategoryByUser(user);
	}
}
