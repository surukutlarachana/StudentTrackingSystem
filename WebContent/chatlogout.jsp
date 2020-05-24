<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="com.ats.util.*" errorPage="chatError.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>You have logged out</title>
<LINK rel="stylesheet" type="text/css" href="./resource/chat.css">
</head>
<body>
<%@ include file="header.jsp" %>
<div align="center">
<center>

<%
	String nickname = (String)session.getAttribute("nickname");
	if (nickname != null && nickname.length() > 0)
	{
		ChatRoomList roomlist = (ChatRoomList) application.getAttribute("chatroomlist");
		ChatRoom chatRoom = roomlist.getRoomOfChatter(nickname);
		chatRoom.addMessage(new Message("system", nickname + " has logged out.", new java.util.Date().getTime()));
		if ( chatRoom != null)
		{
			chatRoom.removeChatter(nickname);
			session.invalidate();
			out.write("<font color=\"blue\">You successfully logged out</font><br/>");
			out.write("<a href=\"chatLogin.jsp\">Login again</a><br/>");
			out.write("<a href=\"login.jsp\">Student</a><br/>");
			out.write("<a href=\"index.html\">Home</a>");
			
		}
		else
		{
			out.write("<h3><font color=\"red\">Unable to logout</font></h3>");
			//response.sendRedirect("login.jsp");
		}
	}
	else
	{
		response.sendRedirect("login.jsp");
	}
	%>
</center>
</div>
</body>
</html>