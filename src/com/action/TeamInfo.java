package com.action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;  
import com.opensymphony.xwork2.*;  
import com.action.ConnectionSQL;  
import org.apache.struts2.ServletActionContext;

public class TeamInfo extends ActionSupport implements ModelDriven<User>{

	

	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	public ArrayList<User_info> getUser_mate1() {
		return User_mate1;
	}
	public void setUser_mate1(ArrayList<User_info> user_mate1) {
		User_mate1 = user_mate1;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getStart1() {
		return start1;
	}
	public void setStart1(String start1) {
		this.start1 = start1;
	}
	public String getEnd1() {
		return end1;
	}
	public void setEnd1(String end1) {
		this.end1 = end1;
	}

	private String date1,date2,start1,end1,message;
    public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	private HttpServletRequest request;  
    private ArrayList<User_info> User_mate1 = new ArrayList<User_info>();
    public User getModel()  
    {  
        return user;  
    }  
    
    HttpSession httpSession =ServletActionContext.getRequest().getSession();
    private User user = (User) httpSession.getAttribute("user");
    public String execute() throws Exception {
    	
    	ConnectionSQL conn=new ConnectionSQL();
    	if(conn.TeamInfo(user, User_mate1)){
   
    		date1 = user.getStart_date();
    		date2 = date1.substring(0, 2);
    		System.out.println(date2);
    		date1 = date1.substring(2, 4);
        	start1 = user.getStart();
        	end1 = user.getEnd();

    		return SUCCESS;
    	} else {
    		message = "Äú»¹Ã»»ï°éÅ¶";
    		return ERROR;
    	}
    	
    } 
    
    
}
