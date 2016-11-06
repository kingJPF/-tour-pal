<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<title>注册界面</title>  
</head>  
<body>  
    <center>  
        <h3>用户注册界面</h3>  
        如果您已有账号，单击此处<a href="login.jsp">登陆</a>  
  
        <form action="register" method ="post">  
        用户名*: <input name="username" type="text"/><br/>  
     <tr>
     <td align="right">性别*：</td>
		<select name="usersex" type="text" > <OPTION value=男 selected>男</OPTION> <OPTION value=女>女</OPTION> 
		</select>
   	<td class="info"> 请选择你的性别</td>
   	</tr></br>
   
   <td align="right"> 年龄 :<input name="userage" type="text"/><br/>
   
   <td align="right"> 密&nbsp;&nbsp;码*: <input name="password" type="password"/><br/> 
   </td>
   <td align="right"> 确认密码*: <input name="password1" type="password"/><br/> 
   </td>
        <input name="submit" type ="submit" value="提交"/>  
        </form><br/><br/><br/>  
    </center>  
</body>  
</html>  