<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include  file="sessionCheck.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>输入匹配信息</title>
</head>
<body bgcolor="#FFEC8B">
<center>  
        <h3>匹配信息</h3>  
      
        <form action="choose" method ="post">  
        &nbsp;初始地*:<input name="start" type="text"/><br/>  
     	<td align="right"> &nbsp;目的地*:<input name="end" type="text"/><br/>
     
     <tr>
     <td align="right">日&nbsp;&nbsp;期*：</td>
		<select name="datemonth" type="text" > <OPTION value=01 selected>01</OPTION> <OPTION value=02>02</OPTION>
		<OPTION value=03>03</OPTION><OPTION value=04>04</OPTION><OPTION value=05>05</OPTION><OPTION value=06>06</OPTION><OPTION value=07>07</OPTION><OPTION value=08>08</OPTION>
		<OPTION value=09>09</OPTION><OPTION value=10>10</OPTION><OPTION value=11>11</OPTION><OPTION value=12>12</OPTION> 
		</select>
   	<td class="info"> 请选择月份</td>
   	</tr></br>
    <tr>
    <td align="right">&nbsp;&nbsp;    </td>
		<select name="dateday" type="text" > <OPTION value=01 selected>01</OPTION> <OPTION value=02>02</OPTION><OPTION value=03>03</OPTION><OPTION value=04>04</OPTION>
		<OPTION value=05>05</OPTION><OPTION value=06>06</OPTION><OPTION value=07>07</OPTION><OPTION value=08>08</OPTION>
		<OPTION value=09>09</OPTION><OPTION value=10>10</OPTION><OPTION value=11>11</OPTION><OPTION value=12>12</OPTION>
		<OPTION value=13>13</OPTION><OPTION value=14>14</OPTION><OPTION value=15>15</OPTION><OPTION value=16>16</OPTION>
		<OPTION value=17>17</OPTION><OPTION value=18>18</OPTION><OPTION value=19>19</OPTION><OPTION value=20>20</OPTION>
		<OPTION value=21>21</OPTION><OPTION value=22>22</OPTION><OPTION value=23>23</OPTION><OPTION value=24>24</OPTION>
		<OPTION value=25>25</OPTION><OPTION value=26>26</OPTION><OPTION value=27>27</OPTION><OPTION value=28>28</OPTION>
		<OPTION value=29>29</OPTION><OPTION value=30>30</OPTION><OPTION value=31>31
		
		</select>
   	<td class="info"> 请选择日</td>
   	</tr></br>
   
  
   <s:property value = "message"/></br>
           <input name="submit" type ="submit" value="提交"/>  
        </form><br/><br/><br/>  
    </center>  



</body>
</html>