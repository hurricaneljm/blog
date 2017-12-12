package com.hurricane.future.blog.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private Logger logger = LoggerFactory.getLogger(getClass());
	private UserService userService;
	public IndexAction() {
		logger.info("indexAction初始化");
	}
	@Autowired
	public void setUserService(UserService userService) {
		logger.info("注入服务对象");
		this.userService = userService;
	}
	
	public String index(){
		logger.debug("请求首页");
		return "index";
	}
	
}
