package com.hurricane.future.blog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Entity
public class Topic {
	private Long id;
	private String name;
	@Id
	@GeneratedValue
	public Long getId() {
		TransactionAspectSupport support;
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(length=255,name="topicName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
