package com.hurricane.future.blog.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * 例如Java,C,linux,windows等
 * @author hurricane
 *
 */
@Entity
@Table(name="blog_category")
public class Category {
	private int id;
	private String name;
	private String description;
	private boolean isRoot;
	private Set<Category> childrens=new HashSet<>();
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
	@Column(nullable=false)
	public boolean isRoot() {
		return isRoot;
	}
	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="childId")
	public Set<Category> getChildrens() {
		return childrens;
	}
	public void setChildrens(Set<Category> childrens) {
		this.childrens = childrens;
	}
	
	
}
