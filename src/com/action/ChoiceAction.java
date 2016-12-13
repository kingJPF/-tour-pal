package com.action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpSession;  
import com.opensymphony.xwork2.*;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.*;

import java.io.PrintWriter;

import javax.servlet.http.*;    
import javax.servlet.http.HttpServletRequest;  
import com.opensymphony.xwork2.*;  
import org.apache.struts2.interceptor.*;  
import com.action.ConnectionSQL;  
import javax.servlet.http.*;  
 
public class ChoiceAction extends ActionSupport implements ModelDriven<User>  

 {

	
    private String message;
    private HttpServletRequest request;  
   
    public User getModel()  
    {  
        return user;  
    }  
    
    HttpSession httpSession =ServletActionContext.getRequest().getSession();
    private User user = (User) httpSession.getAttribute("user");
    
  
    public String execute() throws Exception  
    {  
        //System.out.println(user.getUsername()); 
        ConnectionSQL conn=new ConnectionSQL();
        if(user.getStart().equals("")||user.getEnd().equals("")) {
        	message = "目的地或初始地不能为空！";
        	return INPUT;
        	
        }else{
        	conn.Insert_choice(user);
        	return SUCCESS;
        }
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}  
}
