package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SearchInMapAction extends ActionSupport implements ModelDriven<User>{
	public ArrayList<User_info_more> getUser_mate1() {
		return User_mate1;
	}
	public void setUser_mate1(ArrayList<User_info_more> user_mate1) {
		User_mate1 = user_mate1;
	}
	public String getStartInput() {
		return startInput;
	}
	public void setStartInput(String startInput) {
		this.startInput = startInput;
	}
	public String getEndInput() {
		return endInput;
	}
	public void setEndInput(String endInput) {
		this.endInput = endInput;
	}

	private String startInput,endInput;
    private HttpServletRequest request;  
    private ArrayList<User_info_more> User_mate1 = new ArrayList<User_info_more>();
    public User getModel()  
    {  
        return user;  
    }  
    
    HttpSession httpSession =ServletActionContext.getRequest().getSession();
    private User user = (User) httpSession.getAttribute("user");
    public String execute() throws Exception {
    	ConnectionSQL conn=new ConnectionSQL();
    	System.out.println(startInput+"123");
    	startInput.replaceAll("ÊÐ", "");
    	endInput.replaceAll("ÊÐ", "");
    	System.out.println(startInput+"123");
        user.setStart(startInput);
        user.setEnd(endInput);
        
        if(conn.Match_Map(user,User_mate1)) {
        	
        	return SUCCESS;
        	
        }else{
        	return INPUT;
        }
    }
}
