package com.hurricane.future.blog.action;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hurricane.future.blog.domain.User;
import com.hurricane.future.blog.service.IndexService;
import com.hurricane.future.blog.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends ActionSupport{
	private Logger logger = LoggerFactory.getLogger(getClass());
	private IndexService indexService;
	@Autowired
	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}
	public IndexAction() {
		logger.info("indexAction初始化");
	}
	
	public String index(){
		logger.debug("请求首页");
		User user = new User();
		user.setUserName("李");
		user.setPwd("123");
		user = indexService.findUser(user);
		ServletActionContext.getRequest().getSession().setAttribute("user", user);
		System.out.println(user);
		return "index";
	}
	
}
