package com.hurricane.future.blog.util;

import java.util.HashMap;
import java.util.Map;

public class ValidateResult {
	private boolean isPass=true;
	private Map<String, String> errorMsg = new HashMap<>();
	public boolean isPass() {
		return isPass;
	}
	public void setPass(boolean isPass) {
		this.isPass = isPass;
	}
	public Map<String, String> getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(Map<String, String> errorMsg) {
		this.errorMsg = errorMsg;
	}
	@Override
	public String toString() {
		return "VolidateResult [isPass=" + isPass + ", errorMsg=" + errorMsg + "]";
	}
	
}
