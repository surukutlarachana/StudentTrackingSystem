package com.ats.model;

import java.util.Date;

public class Post {
	private String user;
	private String message;
	private Date date;
	private String collegeName;
	
	public Post(){
		
	}
	
	public Post(String user, String message, Date date,String collegeName) {
		this.user = user;
		this.message = message;
		this.date = date;
		this.collegeName=collegeName;
	}

	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
}
