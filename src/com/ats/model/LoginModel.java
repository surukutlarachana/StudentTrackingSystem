package com.ats.model;

public class LoginModel {

	private String userName;
	private String pwd;
	private String useRoles;
	private String fullName;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	private String error;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUseRoles() {
		return useRoles;
	}
	public void setUseRoles(String useRoles) {
		this.useRoles = useRoles;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
