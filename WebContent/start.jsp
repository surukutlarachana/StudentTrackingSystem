<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page errorPage="chatError.jsp" import="java.util.Set,java.util.Iterator,java.util.Map,com.ats.util.*"%>

<%
	String roomname = request.getParameter("rn");
	String nickname = (String)session.getAttribute("nickname");
	ChatRoomList roomlist = (ChatRoomList) application.getAttribute("chatroomlist");
	if (nickname == null)
	{
		response.sendRedirect("chatLogin.jsp");
	}
	else if (roomname == null)
	{
		response.sendRedirect("listrooms.jsp");
	}
	else
	{
		ChatRoom chatRoom = roomlist.getRoom(roomname);
		if (chatRoom == null)
		{
			out.write("<font color=\"red\" size=\"+1\">Room " + roomname + " not found</font>");
			out.close();
			return;
		}
		ChatRoom chatRoomOld = roomlist.getRoomOfChatter(nickname);
		if (chatRoomOld != null && chatRoom != null)
		{
			Chatter chatter = chatRoomOld.getChatter(nickname);
			
			if (!chatRoomOld.getName().equals(chatRoom.getName()))
			{
				chatRoomOld.removeChatter(nickname);
				chatRoom.addChatter(chatter);
				if (!chatRoomOld.getName().equalsIgnoreCase("StartUp"))
				{
					chatRoomOld.addMessage(new Message("system", nickname + " has left and joined " + 	chatRoom.getName() + ".", new java.util.Date().getTime()));
					
				}
	
					chatRoom.addMessage(new Message("system", nickname + " has joined.", new java.util.Date().getTime()));
					chatter.setEnteredInRoomAt(new java.util.Date().getTime());
				

			}

			if (session.getAttribute("nickname") == null)
			{
				session.setAttribute("nickname", nickname);
			}
			response.sendRedirect("schat.jsp");
		}
		else
		{
			out.write("<span class=\"error\">Some error occured");
		}
	}	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

</body>
</html>