<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<title>登陆界面</title> 
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
<script type="text/javascript">
</script> 

</head>  
    <body bgcolor="#FFEC8B">  
    <center>  
        <h3>用户登录界面</h3>  
        如果您还没注册，单击此处<a href="register.jsp">注册</a>  
  
        <form action="login" method ="post">  
        用户名: <input name="username" type="text"/><br/>  
        密&nbsp码: <input name="password" type="password"/><br/>
        <s:property value = "message"/>  <br/>
        <input name="submit" type ="submit" value="提交"/>  
    </form><br/><br/><br/>  
    </center>  
</body>  
</html>  