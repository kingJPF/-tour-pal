package com.action;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;  
import com.opensymphony.xwork2.*;  
import com.action.ConnectionSQL;  
import org.apache.struts2.ServletActionContext;
import java.util.ArrayList;
import java.sql.*;
import java.util.ArrayList;

import com.action.User;
public class TeamAction extends ActionSupport {
 
	public String getLeadname() {
		return Leadname;
	}
	public void setLeadname(String leadname) {
		Leadname = leadname;
	}
	private String Leadname;
	private String message;
	private ArrayList<User_info> User_mate1 = new ArrayList<User_info>();
	public ArrayList<User_info> getUser_mate1() {
		return User_mate1;
	}
	public void setUser_mate1(ArrayList<User_info> user_mate1) {
		User_mate1 = user_mate1;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	HttpSession httpSession =ServletActionContext.getRequest().getSession();
    private User user = (User) httpSession.getAttribute("user");
	public String execute( ) throws Exception {
		ConnectionSQL conn=new ConnectionSQL();
		if (conn.Team_match(user,Leadname)){
			conn.Match(user,User_mate1);
			message = "»ÎªÔ≥…π¶";
			return SUCCESS;
		} else {
			return INPUT;
		}
		
		
	}
}
