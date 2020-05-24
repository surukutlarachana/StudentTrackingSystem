package com.ats.util;

public class Chatter
{
	private String name = null;
	private String gender = null;
	private String comment = null;
	private String email = null;
	private long loginTime = -1;
	private long enteredInRoomAt = -1;
	private int age = -1;
	
	
	
	public Chatter(String name, String gender, long loginTime)
	{
		this.name = name;
		this.gender = gender;
		this.loginTime = loginTime;
	}	
	
	
	public String getName()
	{
		return name;
	}

	
	public String getGender()
	{
		return gender;
	}
	
	
	public void setComment(String comment)
	{
		this.comment = comment;
	}
	
		
	public String getComment()
	{
		return comment;
	}
	
	
	public void setAge(int age)
	{
		this.age=age;
	}
	
	
	public int getAge()
	{
		return age;
	}
	
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	
	public String getEmail()
	{
		return email;
	}
	
	public long getLoginTime()
	{
		return loginTime;
	}

	

	public void setEnteredInRoomAt( long enteredAt)
	{
		this.enteredInRoomAt = enteredAt;
	}
	
	public long getEnteredInRoomAt()
	{
		return enteredInRoomAt;
	}
	
	
}
