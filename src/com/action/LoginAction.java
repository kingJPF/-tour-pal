package com.action;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpSession;  
import com.opensymphony.xwork2.*;  
import org.apache.struts2.interceptor.*;  
import javax.servlet.http.*;    
import javax.servlet.http.HttpServletRequest;  
import com.opensymphony.xwork2.*;  
import org.apache.struts2.interceptor.*;  
import com.action.ConnectionSQL;  
import javax.servlet.http.*;  
 
  
  
public class LoginAction extends ActionSupport implements ModelDriven<User>,  
        ServletRequestAware  
{  
  
    private User user = new User();  
    private HttpServletRequest request;  
    String name="gu";  
  
    public User getModel()  
    {  
        return user;  
    }  
  
    public void setServletRequest(HttpServletRequest request)  
    {  
        this.request = request;  
  
    }  
  
    public String execute() throws Exception  
    {  
  
        ConnectionSQL conn=new ConnectionSQL();  
          
        if(conn.Select(user)){  
            HttpSession session=request.getSession(true);  
            session.setAttribute("user",user);  
            return SUCCESS;  
              
        }  
        else{return INPUT;}  
          
    }  
  
}  