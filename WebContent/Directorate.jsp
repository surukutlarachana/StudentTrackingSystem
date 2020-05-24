<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.ats.model.*"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
  <li><a class="active" href="Directorate.jsp">Directorate</a></li>
  <li><a href="#mysearch" onclick="view()">Search</a></li>  
  <li><a href="login.jsp">Logout</a></li>
  
</ul>


<form action="directorate" method="post">
<% String fullName="";
	String userName="";
	String role="";
	List<RegistrationModel>stdata=new ArrayList<>();
%>
<%
if(request.getSession().getAttribute("ldata")!=null){
LoginModel mode=(LoginModel)request.getSession().getAttribute("ldata");
fullName=mode.getFullName();
userName=mode.getUserName();
role=mode.getUseRoles();
}
if(request.getSession().getAttribute("sdata") != null){
	stdata=(ArrayList<RegistrationModel>)request.getSession().getAttribute("sdata");
}
%>
<div align="center">
<label>Welcome... <%= fullName%> </label>
<input type="hidden" name=userName value=<%= userName %>>
<input type="hidden" name=roles value=<%= role %>>
</div>
<br/>
<br/>
<br/>

<div id="mysearch" style="border:thin solid green;width:25%;">
<h4 align="center">Search Details:</h4>
<table>
<tbody>
<tr>
<td>
College:</td>
<td>
<input type="text" name="clgName">
</td>
</tr>
<tr>
<td>
StartYear:</td>
<td>
<input type="text" name="styr">
</td>
</tr>
<tr>
<td>
EndYear:</td>
<td>
<input type="text" name="edyr">
</td>
</tr>
<tr>
<td>
Branch:</td>
<td>
<input type="text" name="crs">
</td>
</tr>
<tr>
<td>
CollegeCode:</td>
<td>
<input type="text" name="cc">
</td>
</tr>
<tr>
<td></td>
<td>
<input type="submit" id="submit" value="Search">
</td>
</tr>
</tbody>
</table>
</div>
<br/>
<br/>
<%if(!stdata.isEmpty()){%>
<div style="border:thin solid black;">
<h1 align="center">Student Details</h1>
<table border="1px">
<thead>
<tr>

</tr>
</thead>
<tbody>
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
<!-- <td>Verified</td> -->
</tr>
<%
for(RegistrationModel model:stdata){
%>

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
<!-- <td><%= model.getVerified()%></td> -->
</tr>
<%}%>
</tbody>
</table>
</div>
 <% }%>
</form>
</body>
</html>