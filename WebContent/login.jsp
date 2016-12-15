<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<title>登陆界面</title> 
<link href="//fonts.googleapis.com/css?family=Lobster" rel="stylesheet" type="text/css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
<script  type="text/javascript" src="WebContent/bootstrap/js/jquery-3.1.1.min.js"></script>
</script>
<script type="text/javascript">
</script> 
<script>
  $(document).ready(function() {
    $("button").addClass("animated bounce");
    $(".well").addClass("animated shake");
  });
</script>

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

    <body > 

   
    
    
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
                <h1 class="text-right">用户登陆</h1> 
                </div>
      
          
        </div>
        </div>
         </div>
       
        <div class="container">
        <div class ="jumbotron blue-color">
      
        
        <div class="row">
        

        <form class=text-center action="login" method ="post">
       <div class="col-xs-12 text-center">
         <input name="username" type="text" placeholder="用户名" required>
         </div>
         <div class="col-xs-12 text-center"><h1> </h1></div>
         <div class="col-xs-12 text-center">
         <input name="password" placeholder ="密码" type="password" required>
         </div>
         <div class="col-xs-12 text-center text-danger">
        <s:property value = "message"/>
          </div>
          
          
       
          <div class="col-xs-6 text-right">
        <button type="submit" class="btn btn-primary "> 登陆</button>
           </div>
       
        </form>
           <div class="col-xs-6 text-left"> 
          <button  class="btn btn-danger"onclick="{location.href='register.jsp'}">注册</button>
          </div>
        
   </div>
    </div>
    </div>
    
      
    
</body>  
</html>  