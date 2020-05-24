<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.ats.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Details</title>
<link rel="stylesheet" type="text/css" href="./resource/nav.css"/>

</head>
<body>
<div style=text-align:center;font-size:22px>
<img src="./resource/images/bharat logo.jpg" height=100px width="100px" align="left">
<b>BHARAT INSTITUTE OF ENGINEERING AND TECHNOLOGY
<br/>Accredited by NAAC,Accredited by NBA<br/>Approved by AICTE,Affiliated to JNTUH Hyderabad<br/>Ibrahimpatnam-501 510,Hyderabad.</b>
</div >

<ul>
  <li><a href="chatlogin">Chat Here !</a></li>
  <li><a href="#update"  onclick="view()">Update</a></li>
  <li><a href="logout">Logout</a></li>
  <li><a class="active" href="student.jsp">Back</a></li>
</ul>
<form>
<%
ArrayList<Post>postList=new ArrayList<>();
%>
<%
if(request.getSession().getAttribute("postDetails")!= null){
postList=(ArrayList<Post>)request.getSession().getAttribute("postDetails");
}
%>
<br/>
<br/>
<br/>
<div>
<table border="1px" width="100%">
<thead>
<tr>
<th>Post Details</th>
<th>Time </th>
<th>Event Conducted At </th>
</tr>
</thead>
<tbody>
<%for(Post pots:postList){ %>
<tr>
<td><%=pots.getMessage() %></td>
<td><%=pots.getDate() %></td>
<td><%=pots.getCollegeName()%></td>
</tr>
</tbody>
<%}

%>
</table>
</div>
</form>
</body>
</html>