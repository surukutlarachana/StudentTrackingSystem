<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*,com.ats.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SPOC Page</title>
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
		 document.getElementById('mysearch').style.display = 'none';
	};

	function view() {
		document.getElementById('mysearch').style.display = 'block';
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
  	 <li><a class="active" href="college.jsp">SPOC</a></li>
	 <li><a href="feeds.jsp">Posts</a></li>
  	 <li><a href="email.jsp">Email</a></li>
  	 <li><a href="sms.jsp">SMS</a></li>
  	 <li><a href="#mysearch"  onclick="view()">Search</a></li>
     <li><a href="login.jsp">Logout</a></li>
</ul>
<%
ArrayList<RegistrationModel> data=new ArrayList<>();
ArrayList<RegistrationModel>stuDtls=new ArrayList<>();
%>
	<%
	if(request.getSession().getAttribute("data") != null){
		data = (ArrayList<RegistrationModel>) request.getSession().getAttribute("data");
	}
	if(request.getSession().getAttribute("srData")!=null){
		stuDtls=(ArrayList<RegistrationModel>) request.getSession().getAttribute("srData");
	}
		if (!data.isEmpty()) {
	%>

	<form action="college" method="post">
		<br /> <br /> <br />
		<div align="center" style="border: thin solid black">
			<h3 align="center">Student Verification Details</h3>
			<table border="1px">
				<tr>
					<td>FirstName</td>
					<td>LastName</td>
					<td>RollNo</td>
					<td>DOB</td>
					<td align="center">Email Id</td>
					<td>MobileNumber</td>
					<td align="center">CollegeName</td>
					<td>Course</td>
					<td>Branch</td>
					<td>StartYear</td>
					<td>EndYear</td>
					<td>Excelling</td>
					<td>CollegeCode</td>
					<td colspan="2" align="center">VERIFY</td>
				</tr>

				<c:forEach items="${data}" var="register">
					<tr>
						<td>${register.getFirstName()}<input type="hidden"
							name="fname" value="${register.getFirstName()}">
						</td>
						<td>${register.getLastName()}<input type="hidden"
							name="lname" value="${register.getLastName()}">
						</td>
						<td>${register.getRollno()}<input type="hidden" name="rno"
							value="${register.getRollno()}">
						</td>
						<td>${register.getDob()}</td>
						<td>${register.getEmail()}</td>
						<td>${register.getMobileNumber()}<input type="hidden"
							name="mbno" value="${register.getMobileNumber()}">
						</td>
						<td>${register.getCollegeName()}</td>
						<td>${register.getBranch()}</td>
						<td>${register.getCourse()}</td>
						<td>${register.getStartYear()}</td>
						<td>${register.getEndYear()}</td>
						<td>${register.getExcelling()}</td>
						<td>${register.getCollegeCode()}</td>
						<td>${register.getVerified()}</td>
						<td><input type="submit" id="submit" name="Verify" value="Verify"></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<% } %>
		<br /> <br />  
		<!-- <a href="#mysearch"  onclick="view()">Search</a> -->
		<div id="mysearch" style="border:thin solid green;width:30%;">
			<h3 align="center">Provide Search Details:</h3>
			<table>
				<tbody>
					<tr>
						<td>College:</td>
						<td><input type="text" name="clgName"></td>
					</tr>
					<tr>
						<td>StartYear:</td>
						<td><input type="text" name="styr"></td>
					</tr>
					<tr>
						<td>EndYear:</td>
						<td><input type="text" name="edyr"></td>
					</tr>
					<tr>
						<td>Branch:</td>
						<td><input type="text" name="crs"></td>
					</tr>
					<tr>
						<td>CollegeCode:</td>
						<td><input type="text" name="cc"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" id="submit" name="Search" value="Search"></td>
					</tr>

				</tbody>
			</table>
		</div>
		<br /> <br />
		<% if(!stuDtls.isEmpty()){ %>
		<div style="border:thin solid powderblue">
		<h3 align="center">Student Details</h3>
		<table border="1px">
		<tbody >
		<tr>
		<td>FirstName</td>
		<td>LastName</td>
		<td>RollNo</td>
		<td>DOB</td>
		<td align="center">Email Id</td>
		<td>MobileNumber</td>
		<td align="center">CollegeName</td>
		<td>Course</td>
		<td>Branch</td>
		<td>StartYear</td>
		<td>EndYear</td>
		<td>Excelling</td>
		<td>CollegeCode</td>
		</tr>
			<% for(RegistrationModel model:stuDtls){%>
		<tr>
		<td><%= model.getFirstName()%></td>
		<td><%= model.getLastName()%></td>
		<td><%= model.getRollno()%></td>
		<td><%= model.getDob()%></td>
		<td><%= model.getEmail()%></td>
		<td><%= model.getMobileNumber()%></td>
		<td><%= model.getCollegeName()%></td>
		<td><%= model.getBranch()%></td>
		<td><%= model.getCourse()%></td>
		<td><%= model.getStartYear()%></td>
		<td><%= model.getEndYear()%></td>
		<td><%= model.getExcelling()%></td>
		<td><%= model.getCollegeCode()%></td>
		</tr>
		<%} %>
		</tbody>
		</table>
		</div>
		<%} %>
		
		<!-- 
		<div>
			<a href="feeds.jsp">Posts</a>
		</div>
		<div><a href="email.jsp">Email</a></div>
		 <div>
 			<a href="logout">Logout</a>
 		</div>
 		<div>
 			<a href="sms.jsp">SMS</a>
 		</div> 
 		-->
	</form>
</body>
</html>