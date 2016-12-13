<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>我的队伍信息</title>
</head>
<body bgcolor="#FFEC8B">


   <h1> 现有队伍人员</h1>
	<s:property value = "a"/>
		
			<s:iterator value="User_mate1" id="String" status = "status" >
			<s:property value = "username"/>
			<s:property value = "usersex"/>
			<s:property value = "userage"/> </br>
		</s:iterator>
	 <h1> 队伍出发时间</h1> 2017年<s:property value = "date2"/>月 <s:property value = "date1"/>日</br>
	 <h1> 出发地：</h1><s:property value = "start1"/> </br>
	 <h1> 目的地：</h1><s:property value = "end1"/> </br>
</body>
</html>