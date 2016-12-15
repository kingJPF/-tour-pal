<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<title>注册界面</title>  
<link href="//fonts.googleapis.com/css?family=Lobster" rel="stylesheet" type="text/css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>  
<style>

.blue-color{
background:#F0FFFF;
}
.red-color{
color:red;
}
.text-color{
font-color:#F0FFFF;}
 body{
 background-image:url(pic/6.jpg);
 font-family:"Arial","Microsoft YaHei","黑体","宋体",sans-serif;
 }
.thick-green-border 
   {
    border-color: #87CEFA;
    border-width: 10px;
    border-style: solid;
    border-radius: 50%;
  }

</style>
<body>
     <div class="container">
        <div class ="jumbotron blue-color">
            <div class="row">
            <div class="col-xs-2">
           
            
    <img class="img-responsive thick-green-border" src="pic/7.jpeg">
    </div>
     <div class="col-xs-5 text-primary">
                <h1 class="text-left">驴友网</h1> 
                </div>
                <div class="col-xs-5 text-primary">
                <h1 class="text-right">用户注册</h1> 
                </div>
                
    <div class="col-xs-10 text-danger text-right">
    
    
     <button  class="btn btn-danger"onclick="{location.href='login.jsp'}">返回登陆</button>
    </div>
      
          
        </div>
        </div>
         </div>
         <div class="container">
        <div class ="jumbotron blue-color">
       <div class="row">
       <div class="col-xs-12 text-primary text-center">
                            
  
        <form action="register" method ="post"> 
        <div class="col-xs-12 text-primary text-center"> 
        	<input class="text-center text-primary" name="username" type="text" placeholder="用户名" required>
        	</div>
        	 <div class="col-xs-12 text-primary text-center"><h3> </h3></div>
        <div class="col-xs-12 text-primary text-center"> 	
        <td align="right">性&nbsp;别：</td>
		<select name="usersex" type="text text-primary" > <OPTION value=男 selected>男</OPTION> <OPTION value=女>女</OPTION> 
		</select>
   	
   	</div>
   	 <div class="col-xs-12 text-primary text-center"><h3> </h3></div>
   <div class="col-xs-12 text-primary text-center">
   <input class="text-center"name="userage" type="text text-primary" placeholder="年龄" required>
   </div>
    <div class="col-xs-12 text-primary text-center"><h3> </h3></div>
   <div class="col-xs-12 text-primary text-center">
   
   <input name="password" placeholder ="                  密码" type="password" required> 
   </td>
   </div>
   <div class="col-xs-12 text-primary text-center"><h3> </h3></div>
   <div class="col-xs-12 text-primary text-center">
   <input name="password1" placeholder ="              确认密码" type="password" required>
   </td>
   </div>
   <div class="col-xs-12 text-primary text-center">
   <s:property value = "message"/></br>
   </div>
   <div class="col-xs-12 text-primary text-center">
           <button type="submit" class="btn btn-danger ">注册</button> 
           </div>
        </form>
        </div> 
        </div>
        </div>
        </div>
</body>  
</html>  