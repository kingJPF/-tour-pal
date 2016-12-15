package com.action;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext; 
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

/** 
     * @author lipengcheng 
     * ÓÃ»§×¢Ïú 
     */ 
    private static final long serialVersionUID = 1L;

@SuppressWarnings("unchecked") 
    @Override 
    public String execute() throws Exception { 
        Map<String, Object> attibutes = ActionContext.getContext().getSession(); 
        attibutes.remove("user"); 
        return SUCCESS; 
    } 
}