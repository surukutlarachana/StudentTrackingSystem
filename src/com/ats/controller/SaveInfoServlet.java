package com.ats.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ats.util.*;
/**
 * Servlet implementation class SaveInfoServlet
 */
@WebServlet(name = "SaveInfo", urlPatterns = { "/saveinfo" })
public class SaveInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String nickname = null;
	int age = -1;
	String email = null;
	String comment = null;
	HttpSession session = null;
	String contextPath = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveInfoServlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		nickname = request.getParameter("nickname");
		contextPath = request.getContextPath();
		try
		{
			Integer a = Integer.valueOf(request.getParameter("age"));
			age = a.intValue();
		}
		catch(NumberFormatException nfe)
		{
			age = -1;
		}
		email = request.getParameter("email");
		comment = request.getParameter("comment");
		session = request.getSession(true);
		try
		{
			ChatRoomList roomList = (ChatRoomList) getServletContext().getAttribute("chatroomlist");
			ChatRoom chatRoom = roomList.getRoomOfChatter(nickname);

			
			if (chatRoom != null)
			{
				Chatter chatter = chatRoom.getChatter(nickname);
				chatter.setAge(age);
				chatter.setEmail(email);
				chatter.setComment(comment);
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.write("<html>\n<head>\n<title>Information Saved</title>\n</head>\n<body>\n");
				out.write("<b>Information Saved</b>\n<div align=\"center\">\n<form name=\"closing\">\n");
				out.write("<input type=\"button\" onClick=\"window.close()\" value=\"Close\">\n");
				out.write("</form>\n</div>\n</body>\n</html>");
				out.close();
			}
		}
		catch(Exception ex)
		{
			
			ex.printStackTrace();
			System.out.println("Exception: " + ex.getMessage());
			response.sendRedirect(contextPath + "/chatError.jsp");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
