<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include  file="sessionCheck.jsp"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="//fonts.googleapis.com/css?family=Lobster" rel="stylesheet" type="text/css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    
    
    <script  type="text/javascript" src="WebContent/bootstrap/js/jquery-3.1.1.min.js"></script>
    
    <script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
function TeamInfo()
{
    window.location.href = "TeamInfo";
}

</script>
<script type="text/javascript">
function Logout()
{
    
    window.location.href = "Logout";
}

</script>


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
  p{
  font-size: 30px;
  }
  .downcolor
  {
  background:#F0FFFF;
  }

</style>

<body>


       
 
        
         <%
   if(session.getAttribute("user") != null) // 已经设置过的属性，所有不为空
   {
        HttpSession Session = request.getSession();
         User ses = (User)Session.getAttribute("user");
         String s = ses.getUsername(); //获取session username 
         
         %>
         <div class="container">
        <div class ="jumbotron blue-color">
   <div class="row"> 
   <div class="col-xs-2">
           
            
    <img class="img-responsive thick-green-border" src="pic/7.jpeg">
    </div>
     <div class="col-xs-5 text-primary">
                <h1 class="text-left">驴友网</h1> 
                </div>    
  <div class="col-xs-5 text-primary text-right">
  <h2 class="text-danger ">
  
  <a style=" text-decoration:none" align="left" href="main.jsp">主页</a>  
   
  <a style="text-decoration:none" href="choice.jsp" >组队</a>  
   <a style="text-decoration:none" href="Baidumap.jsp">导航</a>  
   <a style="text-decoration:none" href="TeamInfo">队伍信息</a> 
   </h2>
   </div>
  
   
   <div class="col-xs-12 text-primary text-right">
   <h4 class="text-primary">Hi!   <%=s %></h4>
     </div>
     <div class="col-xs-12 text-primary text-right">
     
   <button  class="btn btn-danger"onclick="Logout()">退出</button>
   
   </div>
    
   </div>
   </div>
   </div>
  <%
   }
   else  // 非法用户，没有登陆通过，则 session 范围内没有属性存在
   {
  %>
  <div class="container">
        <div class ="jumbotron blue-color">
    <div class="row"> 
   <div class="col-xs-2">
           
            
    <img class="img-responsive thick-green-border" src="pic/7.jpeg">
    </div>
     <div class="col-xs-5 text-primary">
                <h1 class="text-left">驴友网</h1> 
                </div>    
  <div class="col-xs-5 text-primary text-right">
  <h2>
  
  <a  style="text-decoration:none" align="left" href="main.jsp">主页</a>  
  <a style="text-decoration:none" href="choice.jsp">组队</a>  
   <a style="text-decoration:none" href="Baidumap.jsp">导航</a>  
   <a style="text-decoration:none" href="TeamInfo">队伍信息</a> 
  
   <div class="col-xs-10 text-primary text-right">
   </h2>
   <div class="col-xs-12 text-primary text-right">
  <button  class="btn btn-primary"onclick="{location.href='login.jsp'}">登陆</button>
  </div>
  <div class="col-xs-12 text-primary text-right">
  <button  class="btn btn-danger"onclick="{location.href='register.jsp'}">注册</button>
  </div>
      
         
       
       
       
   </div>
    </div>
  </div>
  </div>  
  <%
   }
  %>
         




 
 


 


  <div class="container">
        <div class ="jumbotron blue-color">
    <div class="row"> 

    <center>
   <img src="pic/8.jpeg" class="img-responsive">
    
    
    
    
    

<div class="col-xs-4 text-right">
        <div>
        <button  class="btn  btn-primary"onclick="{location.href='choice.jsp'}">匹配队友</button>
        </div>
           </div>
       
        
           <div class="col-xs-4 text-center"> 
          <button  class="btn   btn-primary"onclick="{location.href='Baidumap.jsp'}">路线查询</button>
          </div>
 
<div class="col-xs-4 text-left">
        <button  class="btn  btn-primary"onclick="TeamInfo()">队伍信息</button>
           </div>
       
        
           
</center>
</div>
</div>
</div>

<div class="container">
        <div class ="jumbotron blue-color">
    <div class="row"> 

<div class="col-xs-12 text-center text-danger">
<h1><s:property value = "message"/></h1>
</div>
</div>
</div>
</div>
</body>
</html>