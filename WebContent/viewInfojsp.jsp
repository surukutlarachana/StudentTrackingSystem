<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page errorPage="error.jsp" import="java.util.Set,java.util.Iterator,java.util.Map,com.ats.util.*"%>
<%
String nickname = request.getParameter("chatterName");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE><%=nickname%>'s information</TITLE>
<LINK rel="stylesheet" type="text/css" href="./resource/chat.css">
</head>
<body bgcolor="#FFFFFF">
<%
if (nickname != null)
{
	ChatRoomList roomList = (ChatRoomList)application.getAttribute("chatroomlist");
ChatRoom chatRoom = roomList.getRoomOfChatter(nickname);
if (chatRoom != null)
{
Chatter chatter = chatRoom.getChatter(nickname);
%>
<div align="center">
<center>
<table border="0" width="100%" cellpadding="0" cellspacing="0">
<tr>
	<TD valign="top"><h4>Nickname: </h4></td><TD valign="top"><%=nickname%></td>
</tr>
<tr>
<TD valign="top"><h4>Gender: </h4></td><TD valign="top"><%=chatter.getGender()%></td>
</tr>
<tr>
<TD valign="top"><h4>Age: </h4></td><TD valign="top"><% int age = chatter.getAge();
		if(age == -1)
		out.write("Not specified");
		else
		out.write(String.valueOf(age));
		%></td>
</tr>
<tr>
	<TD valign="top"><h4>Email: </h4></td><TD valign="top"><% String email = chatter.getEmail();
			 if (email != null && email.length() >0)
			  	 out.write(email);
			 else
				 out.write("Not specified");
		%></td>
</tr>
<tr>
<TD valign="top"><H4>Comment: </h4></td><TD valign="top"><%
				String comment = chatter.getComment();
				if (comment != null && comment.length() >0)
					out.write(comment);
				else
					out.write("Not specified");
			%></h4>
</tr>
<tr><TD valign="top">&nbsp;</td>
<TD valign="top">
<form name="closing">
<input type="button" onClick="window.close()" value="Close">
</form>
</td>
<tr>
</table>
</center>
</div>

<%
}
else
{

%>
<div align="center">
<center>
<span class="error">User <%=nickname %> doesn't exist.<br>He / She may have logged out.</span>
<form name="closing">
<input type="button" onClick="window.close()" value="Close">
</form>
</center>
</div>
<%
}
}
else
{
%>
<div align="center">
<center>
<span class="error">No username provided.</span>
</center>
</div>
<%
}
%>
</body>
</html>