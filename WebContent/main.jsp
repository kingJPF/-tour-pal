<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="sessionCheck.jsp"%>
<%@page import="com.action.*"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="com.opensymphony.xwork2.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<TITLE></TITLE>
</HEAD>
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
    this.interval = 3000;  // 过渡一次的间隔时间(过渡时间+图片显示时间)
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
            imgArr[i].src = "pic/" + (i + 1) + ".jpg";
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
<BODY bgcolor="#FFEC8B">


         <%HttpSession Session = request.getSession();
         User ses = (User)Session.getAttribute("user");
         String s = ses.getUsername(); //获取session username %>
<p>欢迎：<%=s %></p>


	<center>
	<table width="300" height="100" id="mainTb">
	    <tr><th rowspan="4"><div id="cnt">&nbsp;</div></td>
	    <td width="15"><span class="ctrl">&nbsp;1&nbsp;</span></td></tr>
	    <tr><td><span class="ctrl">&nbsp;2&nbsp;</span></td></tr>
	    <tr><td><span class="ctrl">&nbsp;3&nbsp;</span></td></tr>
	    <tr><td><span class="ctrl">&nbsp;4&nbsp;</span></td></tr>
	</table> 
输入匹配信息<a href="choice.jsp">输入</a>  

</center>
</BODY>
</HTML>