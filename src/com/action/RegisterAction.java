package com.action;

import javax.servlet.http.HttpSession;  
import com.opensymphony.xwork2.*;  

import com.action.ConnectionSQL;  
  
public class RegisterAction extends ActionSupport implements ModelDriven<User>  
          
{  
    private User user = new User();  
  
  
  
    public User getModel()  
    {  
        return user;  
    }  
  
    public String execute() throws Exception  
    {  
          
        ConnectionSQL conn=new ConnectionSQL();
        if(user.getPassword().equals(user.getPassword1()))
        {
        	if(conn.Insert(user)){  
                
                return SUCCESS;  
                }
        }
          
        return INPUT;  
    }  
  
}  