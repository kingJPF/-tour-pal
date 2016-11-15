package com.action;

import java.sql.Date;

import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport {
	private String username;
	private String password;
	private String password1;
	private String usersex;
	private String userage;
	private int flag;
	private String start;
	private String end;
	private String start_date;
	private String datemonth;
	private String dateday;
	
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getStart_date() {
		return start_date;
	}
	public String getDatemonth() {
		return datemonth;
	}
	public void setDatemonth(String datemonth) {
		this.datemonth = datemonth;
	}
	public String getDateday() {
		return dateday;
	}
	public void setDateday(String dateday) {
		this.dateday = dateday;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passward) {
		this.password = passward;
	}
	public String getUserage() {
		return userage;
	}
	public void setUserage(String userage) {
		this.userage = userage;
	}
	

}
