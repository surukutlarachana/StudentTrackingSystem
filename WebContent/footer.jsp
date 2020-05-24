<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<DIV align="center">
<CENTER>
<TABLE width="100%" border="0" align="center" cellpadding="3" cellspacing="0">
	<TR>
		<TD width="100%" align="center"><%
		String n = (String)session.getAttribute("nickname");
		if (n != null && n.length() > 0)
		{
			out.write("<a href=\"logout.jsp\">Logout</a>");
			out.write(" <a href=\"listrooms.jsp\">List of Rooms</a>");
		}
		%> </TD>
	</TR>
</TABLE>
</CENTER>
</DIV>
</body>
</html>