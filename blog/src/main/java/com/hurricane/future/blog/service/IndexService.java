package com.hurricane.future.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurricane.future.blog.dao.UserDAO;
import com.hurricane.future.blog.domain.User;
import com.sun.org.apache.regexp.internal.recompile;

@Service
public class IndexService {
	private UserDAO userDAO;
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public User findUser(User user){
		if (user==null||user.getUserName()==null||user.getPwd()==null) {
			return null;
		}
		User user2 = userDAO.findUser(user.getUserName(),user.getPwd());
		if (user2==null) {
			return null;
		}
		return user2;
	}
}
