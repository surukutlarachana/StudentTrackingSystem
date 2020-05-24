<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.ats.model.RegistrationModel"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>
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
 font-size: 16px;
 text-decoration: none;
 border: none;
}
#submit:hover {
 border: none;
 background: grey;
 box-shadow: 0px 0px 1px #777;
}
</style>
<script>
	window.onload = function() {
		 document.getElementById('update').style.display = 'none';
	};

	function view() {
		document.getElementById('update').style.display = 'block';
	}
	
</script>
</head>
<body>
<div style=text-align:center;font-size:22px>
<img src="./resource/images/bharat logo.jpg" height=100px width="100px" align="left">
<b>BHARAT INSTITUTE OF ENGINEERING AND TECHNOLOGY
<br/>Accredited by NAAC,Accredited by NBA<br/>Approved by AICTE,Affiliated to JNTUH Hyderabad<br/>Ibrahimpatnam-501 510,Hyderabad.</b>
</div >

<ul>
<li><a href="logout">Home</a></li>
  <li><a class="active" href="student.jsp">Student</a></li>
  <li><a href="chatlogin">Chat Here !</a></li>
  <li><a href="posts">Posts</a></li>
  <li><a href="#update"  onclick="view()">Update</a></li>
  <li><a href="Streaming.html">OnlineStreaming</a></li>
  <!--  <li><a href="chatbot">ChatBot</a></li>
  <li><a href="wcb.jsp">Talk to Waston</a></li>-->
  <li><a href="login.jsp">Logout</a></li>
</ul>

<br/>
<br/>
<br/>
<div align="center">
<form action="updser" method="post"  onSubmit="return checkPassword(this)">
<%
ArrayList<RegistrationModel> data=new ArrayList<>();
%>
<% data= (ArrayList<RegistrationModel>)request.getSession().getAttribute("data");
request.getSession().setAttribute("data1", data);
if(data.isEmpty()){
	data=(ArrayList<RegistrationModel>)request.getSession().getAttribute("data1");
}
%>
<table border="1px">
<c:forEach items="${data}" var="register">
<tr>
<td>FirstName</td>
<td>${register.getFirstName()}</td>
</tr>
<tr>
<td>LastName</td>
<td>${register.getLastName()}</td>
</tr>
<tr>
<td>RollNo</td>
<td>${register.getRollno()}</td>
</tr>
<tr>
<td>DOB</td>
<td>${register.getDob()}</td>
</tr>
<tr>
<td>Email Id</td>
<td>${register.getEmail()}</td>
</tr>
<tr>
<td>MobileNumber</td>
<td>${register.getMobileNumber()}</td>
</tr>
<tr>
<td>CollegeName</td>
<td>${register.getCollegeName()}</td>
</tr>
<tr>
<td>Course</td>
<td>${register.getCourse()}</td>
</tr>
<tr>
<td>Branch</td>
<td>${register.getBranch()}</td>
</tr>
<tr>
<td>StartYear</td>
<td>${register.getStartYear()}</td>
</tr>
<tr>
<td>EndYear</td>
<td>${register.getEndYear()}</td>
</tr>
<tr>
<td>Excelling</td>
<td>${register.getExcelling()}</td>
</tr>
<tr>
<td>CollegeCode</td>
<td>${register.getCollegeCode()}</td>
</tr>
</c:forEach>
</table>
<br/>
<br/>
<br/>

<div style="float:center" id="update">
<label style="text-align:center">Update Student Details</label>
<table>
<tbody>
<tr>
<td>Enter UserName to update the Details:  </td>
</tr>
<tr>
<td>User Name:</td>
<td><input type="text" name="userName"></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="pwd"></td>
<td><label id="pass"></label></td>
</tr>
<!-- <tr>
<td>Retype Password:</td>
<td><input type="password" name="repass"></td>
<td><label id="repa"></label></td>
</tr> -->
<tr>
<td>Email:</td>
<td><input type="email" name="email"></td>
</tr>
<tr>
<td>Mobile Number:</td>
<td><input type="tel" name="mbno" pattern="[0-9]{10}" placeholder="mobilenumber" required/></td>
</tr>
<tr>
<td>Excelling </td>
<td><input type="text" name="exce"></td>
</tr>
<tr>
<td>
<td></td>
<td>
<input type="submit" id="submit" value="Update">
</td>
<tr>
</tbody>
</table>
</div>
<!--  <div align="right">
	<a href="chatlogin">Chat Here !</a>
	<a href="logout">Logout</a>
	<a href="posts">Posts</a>
</div>-->
</form>
</div>
</body>
</html>