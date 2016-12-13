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
	HttpSession httpSession =ServletActionContext.getRequest().getSession();
    private User user = (User) httpSession.getAttribute("user");
	public String execute( ) throws Exception {
		ConnectionSQL conn=new ConnectionSQL();
		if (conn.Team_match(user,Leadname)){
			return SUCCESS;
		} else {
			return INPUT;
		}
		
		
	}
}
