<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="sessionCheck.jsp"%>
<%@page import="com.action.*"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpSession"%>



<%@page import="com.opensymphony.xwork2.*"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<title>Successful match</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
<script type="text/javascript">
function team(e)
{
	var username = document.getElementById("username");
	window.location.href = "team?username="+e.innerHTML;
}

</script>
<body bgcolor="#FFEC8B">


   <h1> 系统为您已匹配到的人员</h1>
	<s:property value = "a"/>
		
			<s:iterator value="User_mate1" id="String" status = "status" >
			<s:property value = "username"/>
			<s:property value = "usersex"/>
			<s:property value = "userage"/>
			<p><a href="Team?leadname=<s:property value="username"/>">匹配该队友</a></p> </br>
		</s:iterator>
		<s:iterator value="User_mate" id='number'> 
    <s:property value='number'/>
		</s:iterator> 
</body>
</html>