<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include  file="sessionCheck.jsp"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="//fonts.googleapis.com/css?family=Lobster" rel="stylesheet" type="text/css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    
    
    <script  type="text/javascript" src="WebContent/bootstrap/js/jquery-3.1.1.min.js"></script>
    
    <script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>我的队伍信息</title>
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
</head>
<style>
#cnt{width:100%;height:80%;}
.ctrl{text-align:center;border:1px solid gray;font-size:12px;cursor:pointer;}
</style>
<script defer='defer'>
<!--
    var curOpac = 0;
    var filterTimer;
    var isIE = /internet explorer/i.test(window.navigator.appName);
    function MyScroll(cnt, control){
        this.data = [];  // 存放图片路径
    this.interval = 30000;  // 过渡一次的间隔时间(过渡时间+图片显示时间)
        this.timer;  // 定时器：控制当前显示的图片
    this.container = cnt;
        this.curFrame = 0;
        this.oldFrame = 0;
        this.controls = control;  // 按钮集合
    Global = this;          // 获取对象的指针
    this.run = function(){
         this.timer = window.setInterval("Global.showFrame()", this.interval);
        }
        // 按钮的处理程序
        this.go = function(i){
            curOpac = 0; // 透明度归0
            this.curFrame = i;  // 当前要过渡的图片
            this.stop();  // 清空计时器
            this.showFrame();  // 当前图片过渡
            this.run();  // 循环播放
        }
        this.stop = function(){
            window.clearInterval(this.timer);
            window.clearInterval(filterTimer);
        }
        this.showFrame = function(){
            // 设置当前按钮样式
      this.controls[this.oldFrame].style.backgroundColor = "white";
            this.controls[this.curFrame].style.backgroundColor = "gray";
            if(isIE) this.container.style.filter = "alpha(opacity=0)";
            else this.container.style.cssText = "-moz-opacity:0";
            this.container.innerHTML = this.data[this.curFrame];
            filterTimer = window.setInterval("blend()", 100);
            this.oldFrame = this.curFrame;
            this.curFrame ++;
            if(this.curFrame == this.data.length){
                this.curFrame = 0;
            }            
        }
    }
     // 增加透明度
    function blend(){
        curOpac+=10;
        if(isIE) Global.container.style.filter='alpha(opacity=' + curOpac + ')';
        else Global.container.style.cssText = "-moz-opacity:" + curOpac/100.0;

        if(curOpac == 100){
            curOpac = 0;
            window.clearInterval(filterTimer);
        }
    }
    //开始
    function startIt(){
        var imgArr = [];
        // 创建4个图片对象保存图片路径
        for(var i=0;i<4;i++){
            imgArr[i] = new Image();
            imgArr[i].src = "pic/" + (i + 1) + ".jpeg";
        }
        var controlArr = $("mainTb").getElementsByTagName("span");
        for(var i=0;i<controlArr.length;i++){
            controlArr[i].tag = i;
            controlArr[i].onclick = function(){
                myScroll.go(this.tag);
            }
        }
        var myScroll = new MyScroll($("cnt"), controlArr);
        myScroll.data.push("<img src='" + imgArr[0].src + "'>");
        myScroll.data.push("<img src='" + imgArr[1].src + "'>");
        myScroll.data.push("<img src='" + imgArr[2].src + "'>");
        myScroll.data.push("<img src='" + imgArr[3].src + "'>");
        myScroll.go(0);
    }
    window.onload = startIt;
    function $(id){ return document.getElementById(id);}
//-->
</script>

<script type="text/javascript">
function Exit()
{
    window.location.href = "ExitTeam";
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
<body >


       
 
        
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

<div class="col-xs-6 text-center text-primary">
   <h2> 现有队伍人员</h2>
   </div>
   <div class="col-xs-5 text-center text-danger">
   <p>
	<s:property value = "a"/>
		
			<s:iterator value="User_mate1" id="String" status = "status" >
			<s:property value = "username"/>
			<s:property value = "usersex"/>
			<s:property value = "userage"/> </br>
		</s:iterator>
		</p>
		</div>
		<div class="col-xs-1 text-center text-danger">
		<button  class="btn btn-danger"onclick="Exit()">退伙</button>
		</div>
		</div>
		</div>
		</div>
		<div class="container">
        <div class ="jumbotron blue-color">
    <div class="row"> 
    <div class="col-xs-6 text-center text-primary">
	 <h2> 队伍出发时间</h2></div>
	 <div class="col-xs-6 text-center text-danger">
	 <p>2017年
	 <s:property value = "date2"/>月 <s:property value = "date1"/>日</br>
	 </p>
	 </div>
	 
	 </div>
        </div>
        </div>
        <div class="container">
        <div class ="jumbotron blue-color">
    <div class="row">
    <div class="col-xs-6 text-center text-primary">
	 <h2> 出发地：</h2>
	 </div>
	 <div class="col-xs-6 text-center text-danger">
	
	 <h2><s:property value = "start1"/></h2>
	 </div>
	 </div>
	 </div>
	 </div>
	 <div class="container">
        <div class ="jumbotron blue-color">
    <div class="row">
	 <div class="col-xs-6 text-center text-primary">
	 <h2> 目的地：</h2>
	 </div>
	 <div class="col-xs-6 text-center text-danger">
	 
	<h2> <s:property value = "end1"/></h2>
	 </div>
	  </div>
        </div>
        </div>
        <input type="submit" id="button" value="退出队伍" onclick="Exit()" />
       
</body>
</html>