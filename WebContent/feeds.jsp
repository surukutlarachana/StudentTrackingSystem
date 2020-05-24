<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,com.ats.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feeds From Colleges</title>
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
</head>
<body>
<div style=text-align:center;font-size:22px>
<img src="./resource/images/bharat logo.jpg" height=100px width="100px" align="left">
<b>BHARAT INSTITUTE OF ENGINEERING AND TECHNOLOGY
<br/>Accredited by NAAC,Accredited by NBA<br/>Approved by AICTE,Affiliated to JNTUH Hyderabad<br/>Ibrahimpatnam-501 510,Hyderabad.</b>
</div >

<ul>
  	 <li><a class="active" href="college.jsp">SPOC</a></li>
  	 <li><a href="email.jsp">Email</a></li>
  	 <li><a href="sms.jsp">SMS</a></li>
     <li><a href="logout">Logout</a></li>
</ul>
<br/>
<br/>
<br/>

<h1>New Message</h1>
	<form action="feeds" method="POST">
	<div aling="center" style="border:thick 1px green">
	<%
		String role="";
		LoginModel model=(LoginModel)request.getSession().getAttribute("lmodel");
		if(model.getUseRoles().equalsIgnoreCase("college")){
	%>
		<table>
		<thead></thead>
		<tbody>
		<tr>
		<td>Name:</td>
		<td><input type="text" name="name" placeholder="Enter firstname and lastname"></td>
		<td>Enter Firstname and Lastname</td>
		</tr>
		<tr>
		<td>Message:</td>
		<td><textarea name="message"></textarea>
		</tr>
		<tr>
		<td>CollegeName:</td>
		<td><input type="text" name="collegeName">
		</tr>
		<tr>
		<td></td>
		<td><button id="submit" type="submit">Send</button></td>
		</tr>
		</tbody>
		</table>	
		<%} %>
	</form>
	
	<hr/>
	
	<h1><%= request.getAttribute("title") %></h1>

	<% 
	List<Post> posts = (List<Post>)request.getAttribute("posts");
	if(posts == null){
	%>
		<p>This user has no posts.</p>
	<%
	}
	else{
		for(Post post : posts){ 
	%>
			<div class="panel panel-default">
				<div class="panel-heading"><h4><a href="/feed/<%= post.getUser() %>"><%= post.getUser() %></a></h4></div>
				<div class="panel-body"><%= post.getMessage() %></div>
				<div class="panel-footer">at <%= post.getDate().toString() %></div>
			
			</div>
	<%
		} 
	}
	%>
</div>
</body>
</html>