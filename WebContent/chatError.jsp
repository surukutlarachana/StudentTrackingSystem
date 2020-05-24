<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isErrorPage="true" import="java.io.PrintWriter" %>
<html>
<head>
<TITLE>Error Occurred</TITLE>
<META http-equiv="pragma" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK rel="stylesheet" href="<%=request.getContextPath()%>/chat.css" type="text/css">
<!-- <link rel="stylesheet" type="text/css" href="./resource/chat.css"/>-->
</head>
<body bgcolor="#FFFFFF">
<h2>Some error occurred</h2>
<pre>
<%
if (exception != null)
{
	//System.out.println("Exception: " +exception.getMessage());
	out.write("<span class=\"error\">Exception: " +exception.getMessage() + "</span><br>");
	exception.printStackTrace( new PrintWriter(out));
}
%>
</pre>
<p>Report to
<%
String admin = null;
if ( ( admin = application.getInitParameter("adminEmail") ) != null )
{
	out.write("<a href=\"mailto:" + admin + "\">" + admin + "</a>");
}

else
{
	out.write("administrator of this web site");
}
%>.

</body>
</html>