package com.hurricane.future.blog.domain;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hurricane.future.blog.util.ValidateResult;

@Entity
@Table(name="blog_user",indexes= {@Index(columnList="userName")})
public class User {
	private Long id;
	private String userName;
	private String tel;
	private String email;
	private String pwd;
	private Set<Category> categories = new HashSet<>();
	public static final String USERNAME_VALIDATERESULT = "USERNAME";
	public static final String TEL_VALIDATERESULT = "TEL";
	public static final String EMAIL_VALIDATERESULT = "EMAIL";
	public static final String PWD_VALIDATERESULT = "PWD";
	public static Logger logger = LoggerFactory.getLogger(User.class);
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(length=20,nullable=false)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(length=20,nullable=false)
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Column(length=30,nullable=false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length=30,nullable=false)
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	
	public ValidateResult validate() {
		ValidateResult result = new ValidateResult();
		if (userName==null||userName.equals("")) {
			result.getErrorMsg().put(User.USERNAME_VALIDATERESULT, "用户名名不能为空");
			result.setPass(false);
		}else if (userName.length()>20) {
			
		}
		if (pwd==null||pwd.equals("")) {
			result.getErrorMsg().put(User.PWD_VALIDATERESULT, "密码不能为空");
			result.setPass(false);
		}else if (pwd.length()>30) {
			
		}
		if (!(tel==null||tel.equals(""))) {
			if (!(tel.matches("[0-9-()（）]{7,18}")||tel.matches("0?(13|14|15|17|18|19)[0-9]{9}"))) {
				result.getErrorMsg().put(User.TEL_VALIDATERESULT, "电话格式不正确");
				result.setPass(false);
				
			}
		}
		if (!(email==null||email.equals(""))) {
			if (!email.matches("\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}")) {
				result.getErrorMsg().put(User.EMAIL_VALIDATERESULT, "邮箱格式不正确");
				result.setPass(false);
			}
			if (email.length()>30) {
				String string = Optional.ofNullable(result.getErrorMsg().get(User.EMAIL_VALIDATERESULT)).orElse("");
				result.getErrorMsg().put(User.EMAIL_VALIDATERESULT, string+" 邮箱长度不能大于30");
				result.setPass(false);
			}
		}
		if (!result.isPass()) {
			logger.warn(result.getErrorMsg().toString());
		}
		return result;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", tel=" + tel + ", email=" + email + ", pwd=" + pwd
				+ ", Categories=" + categories + "]";
	}
	
	
	
}
