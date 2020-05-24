<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isErrorPage="false" errorPage="error.jsp" import="java.util.Set,java.util.Iterator,java.util.Map,com.ats.util.*"%>
<%
String nickname = (String)session.getAttribute("nickname");
if (nickname == null)
{
	out.write("<font color=\"red\" size=\"+1\">You have not logged in.</font>");
	out.close();
	return;
}
ChatRoomList roomList = (ChatRoomList)application.getAttribute("chatroomlist");
ChatRoom chatRoom = roomList.getRoomOfChatter(nickname);
if (chatRoom != null)
{
	Chatter chatter = chatRoom.getChatter(nickname);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit your (<%=chatter.getName()%>'s) Information</title>
<LINK rel="stylesheet" type="text/css" href="./resource/chat.css">
</head>
<body bgcolor="#FFFFFF">
<div align="center">
<center>
<FORM name="chatterinfo" method="post" action="saveinfo">
  <TABLE width="80%" border="0" cellspacing="0" cellpadding="2" align="center" bordercolor="#6633CC">
    <TR>
      <TD><h4>Nickname:</h4></TD>
      <TD><%=chatter.getName()%></TD>
		<input type="hidden" name="nickname" value="<%=chatter.getName()%>">
    </TR>
    <TR>
      <TD><h4>Gender:</h4></TD>
      <TD><%=chatter.getGender()%></TD>
    </TR>
    <TR>
      <TD><h4>Age:</h4></TD>
      <TD>
		<% String temp;
		int age = chatter.getAge();
		if(age == -1)
			temp = "";
		else
			temp = String.valueOf(age);
		%>
        <INPUT type="text" name="age" maxlength="2" size="2" value="<%=temp%>">
      </TD>
    </TR>
    <TR>
      <TD><h4>Email:</h4></TD>
      <TD>
		<%
			temp = chatter.getEmail();
			if(temp == null)
				temp = "Not Specified";			
		%>
        <INPUT type="text" name="email" value="<%=temp%>">
      </TD>
    </TR>
    <TR>
      <TD ><h4>Comment:</h4></TD>
      <TD>
		<% 
			temp = chatter.getComment();
			if(temp==null)
				temp = "Not Specified";		
		%>
        <TEXTAREA cols="30" rows="5" wrap="VIRTUAL" name="comment"><%=temp%></TEXTAREA>
      </TD>
    </TR>
    <TR>
      <TD>&nbsp;</TD>
      <TD>
        <INPUT type="submit" name="Submit" value="Save">
      </TD>
    </TR>
  </TABLE>
</FORM>
</center>
</div>
</body>
</html>
<%
}
else
{
	out.write("<span class=\"error\">Problem getting room information of the chatter</span>");
}
%>