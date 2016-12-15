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

	
    private String message="";
    private HttpServletRequest request;  
    private ArrayList<User_info> User_mate1 = new ArrayList<User_info>();
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
        	message = "出发地或目的地为空";
        	return INPUT;
        	
        }else{
        	conn.Insert_choice(user);
        	if(conn.Match(user,User_mate1)) {
            	
            	return SUCCESS;
            	
            }else{
            	message = "无队友,匹配失败。请重新输入";
            	return INPUT;
            }
        }
    }

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
}
