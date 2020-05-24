<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page  language="java" errorPage="chatError.jsp" import="com.ats.util.*"%>
<%
	String submitted = request.getParameter("submitted");
	boolean postBack = false;
	if (submitted != null && "true".equals(submitted))
	{
		postBack = true;
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK rel="stylesheet" type="text/css" href="./resource/chat.css">
<title>Find chatter</title>
</head>
<body>
<%
	if (postBack)
	{
		String nickname = request.getParameter("fullname");
		String roomName = null;
		if (nickname != null && nickname.length() > 0)
		{
			try
			{
				ChatRoomList roomList = (ChatRoomList)application.getAttribute("chatroomlist");
				ChatRoom chatRoom = roomList.getRoomOfChatter(nickname);
				if (chatRoom != null)
				{
					roomName = chatRoom.getName();
				}
				if (roomName == null)
				{
					out.write("<h3><i>" + nickname + "</i> not found in any room</h3>");
				}
				else
				{
					out.write("<h3><i>" + nickname + "</i> is in room " + roomName + "</h2>");
				}

			}
			catch (Exception e)
			{
				out.write("<h1>Some problem with server</h1>");
			}
		}
		else
		{
			out.write("<h4 class=\"error\">Please enter nickname of the person you want to find below</h4>");
		}
	}
%>
<H2>Enter nickname of the person you want to find.</H2>
<FORM action="find.jsp" method="post" name="find" id="find">
<STRONG>Nickname </STRONG>
		<INPUT name="nickname" type="text" id="nickname">
		<INPUT type="hidden" name="submitted" value="true">
		<input type="submit" value="Find">
</FORM>
<div align="center">
<center>
<form name="closing">
	<input type="button" onClick="window.close()" value="Close">
</form>
</center>
</div>
</body>
</html>