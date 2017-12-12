package com.hurricane.future.blog.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurricane.future.blog.dao.TopicDAO;
import com.hurricane.future.blog.dao.UserDAO;
import com.hurricane.future.blog.domain.User;
@Service
public class UserService {
	private Integer integer =0;
	private UserDAO userDAO;
	private TopicDAO topicDAO;
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	@Autowired
	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}
	public void saveUser(User user)throws Exception {
//		integer++;
//		logger.info("begin service this iInteger is "+integer);
//		try {
//			Thread.sleep(8000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		logger.info("end sleep this iInteger is "+integer);
//		Topic topic = new Topic();
//		topic.setId((long) 2);
//		topic.setName(user.getUserName()+" topic");
//		topicDAO.save(topic);
//		logger.info("执行topicsave完毕");
//		userDAO.save(user);
//		logger.info("执行usersave完毕");
				throw new RuntimeException("测试是否回滚");

	}
}
