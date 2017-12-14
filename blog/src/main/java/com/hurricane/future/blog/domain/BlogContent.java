package com.hurricane.future.blog.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="blog_blogcontent")
public class BlogContent {
	private long id;
	private String topic;
	private String content;
	private boolean isIssue;
	private Set<LinkFile> linkfiles = new HashSet<>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(length=250,nullable=false)
	public String getTopic() {
		return topic; 
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	@Column(nullable=false,columnDefinition="text")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
//	@ManyToOne
//	@JoinColumn(name="userId")
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	@Column(nullable=false)
	public boolean isIssue() {
		return isIssue;
	}
	public void setIssue(boolean isIssue) {
		this.isIssue = isIssue;
	}
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="blogContent_id")
	public Set<LinkFile> getLinkfiles() {
		return linkfiles;
	}
	public void setLinkfiles(Set<LinkFile> linkfiles) {
		this.linkfiles = linkfiles;
	}
	
	
}
