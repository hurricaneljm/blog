package com.hurricane.future.blog.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hurricane.future.blog.domain.User;
import com.hurricane.future.blog.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends ActionSupport{
	private Logger logger = Logger.getLogger(getClass());
	private Integer tInteger=0;
	private UserService userService;
	public IndexAction() {
		logger.info("indexAction初始化");
	}
	@Autowired
	public void setUserService(UserService userService) {
		logger.info("注入服务对象");
		this.userService = userService;
	}
	
	public String index() {
		logger.info(Thread.currentThread().getName());
		logger.info("begin index");
		logger.info(userService.toString());
		User user = new User();
		user.setUserName("test");
		userService.saveUser(user);
		logger.info("before return");
		tInteger++;
		ActionContext.getContext().getValueStack().set("name", tInteger);
		return "index";
	}
	
	public String index2() { 
		logger.info(Thread.currentThread().getId());
		logger.info("begin index");
		logger.info(userService.toString());
		User user = new User();
		user.setUserName("tornado");
		userService.saveUser(user);
		logger.info("before return");
		tInteger++;
		ActionContext.getContext().getValueStack().set("name", tInteger);
		return "index";
	}
}
