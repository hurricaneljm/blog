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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Entity
@Table(name="blog_subcategory")
public class SubCategory {
	private int id;
	private String name;
	private String description;
	private Set<BlogContent> blogContents = new HashSet<>();
	public static final String NAME_VALIDATERESULT = "NAME";
	public static final String DESCRIPTION_VALIDATERESULT = "DESCRIPTION";
	private static Logger logger = LoggerFactory.getLogger(SubCategory.class);
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(length=20,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=500,nullable=false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="subcategory_id")
	public Set<BlogContent> getBlogContents() {
		return blogContents;
	}
	public void setBlogContents(Set<BlogContent> blogContents) {
		this.blogContents = blogContents;
	}
	
	
}
