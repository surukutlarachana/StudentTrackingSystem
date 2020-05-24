<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send Sms</title>
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
<body>
<div style=text-align:center;font-size:22px>
<img src="./resource/images/bharat logo.jpg" height=100px width="100px" align="left">
<b>BHARAT INSTITUTE OF ENGINEERING AND TECHNOLOGY
<br/>Accredited by NAAC,Accredited by NBA<br/>Approved by AICTE,Affiliated to JNTUH Hyderabad<br/>Ibrahimpatnam-501 510,Hyderabad.</b>
</div >

<ul>
  	 <li><a class="active" href="college.jsp">SPOC</a></li>
  	 <li><a href="email.jsp">Email</a></li>
  	 <li><a href="feeds.jsp">Posts</a></li>
     <li><a href="logout">Logout</a></li>
</ul>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<div align="center">
<form action="sendsms"method="get">
	<table>
	<thead>SMS</thead>
	<tbody>
	<tr>
	<td><label>To:</label><input type="text" name="mbno"></td>
	</tr>
	<tr>
		<td><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><textarea name="smsmessage" rows="20"></textarea><td>
	</tr>
	<tr align="center">
	<td><input type="submit" id="submit" value="Send"></td>
	</tr>
	</tbody>
	</table>
</form>
</div>
</body>
</html>