package com.hurricane.future.blog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hurricane.future.blog.util.ValidateResult;
@Entity
public class LinkFile {
	private int id;
	private String fileName;
	private String saveFileName;
	private String saveFilePath;
	private String description;
	public static final String FILENAME_VALIDATERESULT = "FILENAME";
	private static Logger logger = LoggerFactory.getLogger(LinkFile.class);
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(nullable=false,length=255)
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Column(nullable=false,length=64)
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	@Column(nullable=false,length=255)
	public String getSaveFilePath() {
		return saveFilePath;
	}
	public void setSaveFilePath(String saveFilePath) {
		this.saveFilePath = saveFilePath;
	}
	@Column(nullable=false,length=255)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ValidateResult validate() {
		ValidateResult result = new ValidateResult();
		if (fileName==null||fileName.equals("")) {
			result.getErrorMsg().put(LinkFile.FILENAME_VALIDATERESULT, "文件名不能为空");
			result.setPass(false);
		}else if (fileName.length()>255) {
			result.getErrorMsg().put(LinkFile.FILENAME_VALIDATERESULT, "文件名长度不能超过255");
			result.setPass(false);
		}
		
		if (!result.isPass()) {
			logger.warn(result.getErrorMsg().toString());
		}
		return result;
	}
	
	
	
}
