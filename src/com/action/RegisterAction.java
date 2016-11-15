package com.action;

import javax.servlet.http.HttpSession;  
import com.opensymphony.xwork2.*;  

import com.action.ConnectionSQL;  
  
public class RegisterAction extends ActionSupport implements ModelDriven<User>
          
{  
    private User user = new User();  
    private String message;
  
  
    public User getModel()  
    {  
        return user;  
    }  
  
    public String execute() throws Exception  
    {  
          
        ConnectionSQL conn=new ConnectionSQL();
        if(user.getPassword().equals(user.getPassword1())) {
        	if(conn.Insert(user)){                
                return SUCCESS;  
            } else{
            	message = "用户名已被占用";
            	return INPUT;
            }
        }
        message = "两次密码不一致";  
        return INPUT;  
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}  
  
}  