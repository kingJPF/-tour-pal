package com.action;
import java.sql.Date;

import com.opensymphony.xwork2.ActionSupport;
public class User_info_more extends ActionSupport {
	
	public String getUserday() {
		return userday;
	}
	public void setUserday(String userday) {
		this.userday = userday;
	}
	public String getUsermonth() {
		return usermonth;
	}
	public void setUsermonth(String usermonth) {
		this.usermonth = usermonth;
	}
	private String username;
	private String usersex;
	private String userage;
	private String userday;
	private String usermonth;
	public User_info_more(String name ,String sex,String age,String day,String month)
	{
		username = name;
		usersex = sex;
		userage = age;
		userday = day;
		usermonth = month;
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
	
}
