<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String name;
%>
<%
name= (String)request.getSession().getAttribute("fullname");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administration of Alumni</title>
<link rel="stylesheet" type="text/css" href="./resource/nav.css"/>

</head>
<body>
<div style=text-align:center;font-size:22px>
<img src="./resource/images/bharat logo.jpg" height=100px width="100px" align="left">
<b>BHARAT INSTITUTE OF ENGINEERING AND TECHNOLOGY
<br/>Accredited by NAAC,Accredited by NBA<br/>Approved by AICTE,Affiliated to JNTUH Hyderabad<br/>Ibrahimpatnam-501 510,Hyderabad.</b>
</div >

<ul>
	 <li><a href="logout">Home</a></li>
  	 <li><a class="active" href="admin.jsp">Administrator</a></li>
  	 <li><a href="AddDirectorate.html">Add Directorate</a></li>
  	 <li><a href="AddSpoc.html">Add SPOC(college)</a></li>
  	<li><a href="login.jsp">Logout</a></li>
  	 
</ul>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

<h1 align="center">Welcome <%= name%></h1>

	
	<!--<div align="center">
	<table>
	<tbody>
	<tr>
	<td><a href="AddDirectorate.html">Add Directorate</a></td>
	</tr>
	<tr>
	<td><a href="AddSpoc.html">Add SPOC(college)</a></td>
	</tr>
	 <tr>
	<td><a href="UpdateDirectorate.html">Update Directorate</a></td>
	</tr>
	<tr>
	<td><a href="UpdateSpoc.html">Update SPOC(college)</a></td>
	</tr> 
	</tbody>
	</table>
</div>-->

</body>
</html>