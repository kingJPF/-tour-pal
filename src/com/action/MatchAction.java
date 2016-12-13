package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;  
import com.opensymphony.xwork2.*;  

import com.action.ConnectionSQL;  
import org.apache.struts2.ServletActionContext;

public class MatchAction extends ActionSupport implements ModelDriven<User> {
	
	private String message;
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
        System.out.println(user.getUsername());
        if(conn.Match(user,User_mate1)) {
        	
        	System.out.println("匹配成功");
        	message = " 匹配成功";
        	return SUCCESS;
        	
        }else{
        	message = "匹配失败";
        	System.out.println("匹配失败");
        	return INPUT;
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
