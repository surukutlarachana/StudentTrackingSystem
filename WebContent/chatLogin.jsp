<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page errorPage="error.jsp" %>
<%
	String nickname = (String)session.getAttribute("nickname");
	if (nickname != null)
	{
		response.sendRedirect("listrooms.jsp");
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat - Login</title>
<script>
	
	 if(window.top != window.self)
	 {
		 window.top.location = window.location;
	 }
	 
 </script>
	 <LINK rel="stylesheet" href="./resource/chat.css">
	 <LINK rel="stylesheet" href="./resource/nav.css">
</head>
<body bgcolor="#FFFFFF" onLoad="document.chatLogin.nickname.focus();">


<div style=text-align:center;font-size:22px>
<img src="./resource/images/bharat logo.jpg" height=100px width="100px" align="left">
<b>BHARAT INSTITUTE OF ENGINEERING AND TECHNOLOGY
<br/>Accredited by NAAC,Accredited by NBA<br/>Approved by AICTE,Affiliated to JNTUH Hyderabad<br/>Ibrahimpatnam-501 510,Hyderabad.</b>
</div >

<ul>
  <li><a href="logout">Home</a></li>
  <li><a class="active" href="chatLogin.jsp">Chat</a></li>
  <li><a href="student.jsp">Student</a></li>
  <li><a href="chatlogout.jps">Logout From chat</a></li>
  <li><a href="login.jsp">Logout</a></li>
</ul>
<br/>
<br/>
<%@ include file="/header.jsp" %>
<TABLE width="40%" border="0" cellspacing="1" cellpadding="1" align="center">
      <%
      String d=request.getParameter("d");
      String n=request.getParameter("n");
      String ic = request.getParameter("ic");
		
          if (d!=null && d.equals("t"))
          {
      %>
      <TR>
        <TD>
          <TABLE width="100%" border="0" cellspacing="1" cellpadding="1" align="center">
            <TR>
              <TD colspan="2" align="center">
                <SPAN class="error">Nickname exists</SPAN><BR>
              </TD>
            </TR>
				<TR>
              <TD colspan="2">
                Nickname <B><%=n%></B> has already been taken please select some other nick.
              </TD>
            </TR>
          </TABLE>
        </TD>
      </TR>
      <%
        }
        else if (ic!=null && ic.equals("t"))
        {
      %>
      <TR>
        <TD colspan="2">
          <TABLE width="100%" border="0" cellspacing="1" cellpadding="1" align="center">
            <TR>
              <TD colspan="2" align="center">
                <SPAN class="error">Incomplete information</SPAN>
              </TD>
            </TR>
				<TR>
              <TD colspan="2">
                <b>Sex</b> and <b>Nickname</b> must be entered and nickname must be atleast <b>4</b> characters long and must not contain any <b>space</b>.
              </TD>
            </TR>
          </TABLE>
        </TD>
      </TR>
      <%
        }
      %>
      <TR>
        <TD colspan="2" class="panel">
          <FORM name="chatlogin" method="post" action="chatlogin">
            <TABLE width="100%" border="0">
              <TR>
                <TD width="30%" class="white">
                  Nickname
                </TD>
                <TD width="70%">
                  <INPUT type="text" name="nickname" size="15">
                </TD>
              </TR>
              <TR>
                <TD width="30%" class="white">
                  Gender
                </TD>
                <TD width="70%">
                  <SELECT size="1" name="gender">
                    <OPTION value="m">
                      Male
                    </OPTION>
                    <OPTION value="f">
                      Female
                    </OPTION>
                  </SELECT>
                </TD>
              </TR>
              <TR>
                <TD>
                 &nbsp;  
                </TD>
                <TD>
                  <INPUT type="submit" name="Submit" value="Submit">
                  </TD>
                  <TD>
                 &nbsp;  
                </TD>
                  <TD>
                  
                </TD>
                
              </TR>
            </TABLE>
          </FORM>
        </TD>
      </TR>
    </TABLE>
</body>
</html>