package com.hurricane.future.blog.domain;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hurricane.future.blog.util.ValidateResult;

/**
 * 需要新增创建日期
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
//	private Set<Category> childrens=new HashSet<>();//hibernate不适合实现子连接
//	private Set<BlogContent> blogContents = new HashSet<>();//交由SubCategory类进行关联
	private Set<SubCategory> subCategories = new HashSet<>();
	public static final String NAME_VALIDATERESULT = "NAME";
	public static final String DESCRIPTION_VALIDATERESULT = "DESCRIPTION";
	private static Logger logger = LoggerFactory.getLogger(Category.class);
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
	
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//	@JoinColumn(name="childId", referencedColumnName="childId")
//	public Set<Category> getChildrens() {
//		return childrens;
//	}
//	public void setChildrens(Set<Category> childrens) {
//		this.childrens = childrens;
//	}

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="category_id")
	public Set<SubCategory> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(Set<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}
	public ValidateResult validate() {
		ValidateResult result = new ValidateResult();
		//验证分类名称
		if (name==null||name.equals("")) {
			result.getErrorMsg().put(Category.NAME_VALIDATERESULT, "分类名称不能为空");
			result.setPass(false);
		}else if (name.length()>20) {
			String string = Optional.ofNullable(result.getErrorMsg().get(Category.NAME_VALIDATERESULT)).orElse("");
			result.getErrorMsg().put(Category.NAME_VALIDATERESULT, string+" 分类名称不能为空");
			result.setPass(false);
		}
		if (description!=null&&description.length()>500) {
			result.getErrorMsg().put(Category.DESCRIPTION_VALIDATERESULT, "分类描述字符数不能超过500");
			result.setPass(false);
		}
		if (!result.isPass()) {
			logger.warn(result.getErrorMsg().toString());
		}
		return result;
	}
	
}
