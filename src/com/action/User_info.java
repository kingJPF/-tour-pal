package com.action;
import java.sql.Date;

import com.opensymphony.xwork2.ActionSupport;
public class User_info extends ActionSupport {
	private String username;
	private String usersex;
	public User_info(String name ,String sex,String age)
	{
		username = name;
		usersex = sex;
		userage = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public String getUserage() {
		return userage;
	}
	public void setUserage(String userage) {
		this.userage = userage;
	}
	private String userage;
}
