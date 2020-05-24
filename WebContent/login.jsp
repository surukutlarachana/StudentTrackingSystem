<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Details</title>
<link rel="stylesheet" type="text/css" href="./resource/nav.css"/>
<style>
#submit {
 background-color: #bbb;
 padding: .3em;
 -moz-border-radius: 3px;
 -webkit-border-radius: 3px;
 border-radius: 6px;
 color: #fff;
 font-family: 'Oswald';
 font-size: 18px;
 text-decoration: none;
 border: none;
}
#submit:hover {
 border: none;
 background: grey;
 box-shadow: 0px 0px 1px #777;
}
</style>
</head>
<!--  background="./resource/images/img2.jpg"-->
<body>
<div style=text-align:center;font-size:22px>
<img src="./resource/images/bharat logo.jpg" height=100px width="100px" align="left">
<b>BHARAT INSTITUTE OF ENGINEERING AND TECHNOLOGY
<br/>Accredited by NAAC,Accredited by NBA<br/>Approved by AICTE,Affiliated to JNTUH Hyderabad<br/>Ibrahimpatnam-501 510,Hyderabad.</b>
</div >
<ul>
  <li><a class="active" href="login.jsp">Administrator</a></li>
  <li><a href="login.jsp">College</a></li>
  <li><a href="login.jsp">Student</a></li>
  <li><a href="login.jsp">Directorate</a></li>
  <li><a href="logout">Back</a></li>
</ul>
<br/>
<br/>
<br/>
<br/>
<div style="text-align:center;">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!-- <a href="logout"><img src="./resource/images/home1.jpg" alt="Logout"/></a> -->
</div>
<h1 align="center">Login</h1>
<div align="center">
<form action="Login" method="post">
<div style="border:thin solid green;width:30%;">
<table>
<tbody>
<tr>
<td><h3>UserName:</h3></td>
<td><input type="text" name="userName" placeholder="EnterUserName" required/></td>
</tr>
<tr>
<td><h3>Password:</h3></td>
<td><input type="password" name="pwd" placeholder="EnterPassword" required/></td>
</tr>
<tr>
<td><h3>Logging in as:</h3>
<td>
<select name ="roles" id="roles" size=1 required>
  <option selected> select</option>
  <option value="admin">Admin</option>
  <option value="student">Student</option>
  <option value="college">College</option>
  <option value="directorate">Directorate</option>
</select>
</td>
</tr>
<tr>
<td></td>
<td><input type="submit" id="submit" value="Login"/></td>
</tr>
</tbody>
</table>
</div>
</form>
</div>
</body>
</html>