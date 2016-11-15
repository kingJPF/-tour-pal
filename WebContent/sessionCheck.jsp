<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.action.*"%>

<%
User obj = (User)session.getAttribute("user");
if(obj==null){
out.print("你没有登录");
response.sendRedirect("login.jsp");
}else{
User model=(User)obj;
}
%>
