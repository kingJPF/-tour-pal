<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.action.*"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" import="java.sql.*,java.io.*,java.util.*"%> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>路线导航</title>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.2">

</script>
<%/*HttpSession Session = request.getSession();
         User ses = (User)Session.getAttribute("user");
        
         String name = ses.getUsername(); 
        PreparedStatement ps=null; 
         Connection conn=null;
        //驱动程序名   
        String driverName = "com.mysql.jdbc.Driver";  
        //数据库用户名   
        String userName = "root";  
        //密码   
        String userPasswd = "971213";  
        //数据库名   
        String dbName = "web_user";  
        //表名   
        String tableName = "user";  
        //联结字符串   
       Class.forName("com.mysql.jdbc.Driver");  
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/struts_tutorial","root","1234");  
            String sql=  
                    "select * from user where userid = ?";  
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
        	ResultSet rs = ps.executeQuery();  
        	String start = "";
        	String end ="";
        	while (rs.next()){
            	 start = rs.getString("start");
            	 end = rs.getString("end");
            	}
        */	
    %>
<style>
body{font-size:14px;}
h5{line-height:3em;padding:0;margin:0;}
a{color:#EE3399;}
a:hover{color:#99AA66;}
.txt{border:1px solid #ccc;background:none;padding:1px;}
.f-l{float:left;}
.t-c{text-align:center;}
.clear{clear:both;}
.hidden{display:none;}
.searchbox{border:4px solid #e5ecf9;height:40px;float:left;line-height:40px;padding:0 20px;margin:0 0 0 50px;}
.mainbox{margin:20px 0 0;}
.boxmap{width:500px;height:400px;border:1px solid gray;float:left;}
.boxpanel{width:250px;float:left;margin:0 0 0 10px;border:1px solid gray;padding:0 10px 10px;}
#startPanel,#endPanel{border:1px solid #FA8722;font-size:12px;}
#startPanel div,#endPanel div{padding:5px;}
#startPanel p,#endPanel p{margin:0;paddin:0;line-height:1.2em;}
#drivingPanel{border:1px solid #6688EE;}

</style>
</head>
<body>
<div>
<from>
     <div class="searchbox">
    
        从<input class="txt" type="text" id="startInput" name = "startInput"/>
    到
    <input class="txt" type="text" id="endInput" name = "endInput" />
    &nbsp; 
    <input type="submit" id="button" value="查询路径" onclick="mDriving()" />
        公里数：<input class="txt" type="text" id="gls">
        
        <input type="submit" id="button" value="查询该路线上的用户" onclick="Search()" />
        
    </div>
 </from>
</div>
<div class="clear"></div>
<div class="mainbox">
    <div class="boxmap" id="container"></div>
    <div class="boxpanel hidden" id="box">
        <h5>起点选择&nbsp;<a href="#" onclick="document.getElementById('startPanel').style.display='block';">(展开)</a></h5>
        <div id="startPanel"></div>
        <h5>终点选择&nbsp;<a href="#" onclick="document.getElementById('endPanel').style.display='block';">(展开)</a></h5>
        <div id="endPanel"></div>
        <!--<h5>驾车导航</h5>
        <div id="drivingPanel"></div>-->
    </div>
</div>
<s:property value = "a"/>
		
			<s:iterator value="User_mate1" id="String" status = "status" >
			<s:property value = "username"/>
			<s:property value = "usersex"/>
			<s:property value = "userage"/>
			<s:property value = "usermonth"/>月
			<s:property value = "userday"/>日
			<a href="Team?leadname=<s:property value="username"/>">匹配该队友</a> </br>
</s:iterator>
</body>

</html>
<script type="text/javascript">

function Search()
{
	var startInput=document.getElementById('startInput').value;
	var endInput=document.getElementById('endInput').value;
	window.location.href = "SearchInMap?startInput=" + startInput + "&endInput=" + endInput;
}

var map = new BMap.Map("container");            // 创建Map实例
var point = new BMap.Point(121.50, 31.30);    // 创建点坐标
map.centerAndZoom(point,11);                     // 初始化地图,设置中心点坐标和地图级别。
map.enableScrollWheelZoom();                  // 启用滚轮放大缩小。
 
var startInfowin = new BMap.InfoWindow("<p class='t-c'><input value='选为起点' type='button' onclick='startDeter();' /></p>");
var endInfowin = new BMap.InfoWindow("<p class='t-c'><input value='选为终点' type='button' onclick='endDeter();' /></p>");
 
var startResults = null;
var endResults = null;
 


var startPoint,starttitle;
var endPoint,endtitle;
var startOption = {
  onSearchComplete: function(results){
    // 判断状态是否正确
    if (startSearch.getStatus() == BMAP_STATUS_SUCCESS){
      startResults = results;
      var s = [];
      for (var i = 0; i < results.getCurrentNumPois(); i ++){
        s.push("<div><p><a onclick = 'document.getElementById(\"startInput\").value=\""+results.getPoi(i).title+"\"' onmouseover='map.openInfoWindow(startInfowin,startResults.getPoi(" + i + ").point);' href='#'>");
        s.push(results.getPoi(i).title);
        s.push("</a></p><p>");
        s.push(results.getPoi(i).address);
        s.push("</p></div>");
      }
      document.getElementById("startPanel").innerHTML = s.join("");
    }else{startResults = null;}
  }
};
var endOption = {
  onSearchComplete: function(results){
    // 判断状态是否正确
    if (endSearch.getStatus() == BMAP_STATUS_SUCCESS){
      endResults = results;
      var s = [];
      for (var i = 0; i < results.getCurrentNumPois(); i ++){
        s.push("<div><p><a href='#' onclick = 'document.getElementById(\"endInput\").value=\""+results.getPoi(i).title+"\"' onmouseover='map.openInfoWindow(endInfowin,endResults.getPoi(" + i + ").point);'>");
        s.push(results.getPoi(i).title);
        s.push("</a></p><p>");
        s.push(results.getPoi(i).address);
        s.push("</p></div>");
      }
      document.getElementById("endPanel").innerHTML = s.join("");
    }else{endResults = null;}
  }
};
//创建2个搜索实例
var startSearch = new BMap.LocalSearch(map,startOption);
var endSearch = new BMap.LocalSearch(map,endOption);
 
function mDriving(){
    var startPlace = document.getElementById("startInput").value;
    var endPlace = document.getElementById("endInput").value;
    startSearch.search(startPlace);
    endSearch.search(endPlace);
    document.getElementById("box").style.display="block";
}
 
function startDeter(){
    map.clearOverlays();
    startPoint = startInfowin.getPosition();
    var marker = new BMap.Marker(startPoint);
    map.addOverlay(marker);
    document.getElementById("startPanel").style.display="none";
    //document.getElementById("startInput").value=starttitle;
}
function endDeter(){    
    if(startPoint==null){alert("请先选择起点！");}
    else{
        endPoint = endInfowin.getPosition();        
        transit.search(startPoint,endPoint);
        document.getElementById("endPanel").style.display="none";
    }
}
 
         
         
         
function searchComplete(results){
    if (transit.getStatus() != BMAP_STATUS_SUCCESS){
        return ;
    }
        var plan = results.getPlan(0);
        var val = plan.getDistance(true);
        document.getElementById("gls").value=plan.getDistance(true);
        //document.getElementById("drivingPanel").value=val;
}
var transit = new BMap.DrivingRoute(map, {renderOptions: {map: map}, onSearchComplete: function(results){searchComplete(results);}});
</script>