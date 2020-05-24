package com.ats.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.util.ChatRoom;
import com.ats.util.ChatRoomList;
import com.ats.util.Chatter;
 /**
 * Servlet implementation class ChatLogin
 */
@WebServlet(name = "Chats", urlPatterns = { "/chatlogin" })
public class ChatLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String contextPath = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatLogin() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contextPath = request.getContextPath();
		System.out.println(contextPath);
		response.sendRedirect(contextPath+"/chatLogin.jsp");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   contextPath = request.getContextPath();		
	   System.out.println(contextPath);
		String nickname = request.getParameter("nickname");
		nickname = nickname.trim().toLowerCase();
		System.out.println(nickname);
		String gender = request.getParameter("gender");
		if (gender.length() > 0)
		{
			gender = gender.trim().toLowerCase();
		}
		if ((nickname != null && nickname.length() > 3 && nickname.indexOf(" ") == -1) && (gender != null && (gender.equals("m") || gender.equals("f") ) ))
		{
			try
			{
				ChatRoomList roomlist = (ChatRoomList)getServletContext().getAttribute("chatroomlist");
				boolean chatterexists = roomlist.chatterExists(nickname);
				if (chatterexists)
				{
					response.sendRedirect(contextPath+"/chatLogin.jsp?d=t&n="+nickname);
				}
				else
				{
					HttpSession session = request.getSession(true);
					int timeout = 1800; // 30 minutes
					String t = getServletContext().getInitParameter("sessionTimeout"); // gets Minutes
					if (t != null)
					{
						try
						{
							timeout = Integer.parseInt(t);
							timeout = timeout * 60;
						}
						catch (NumberFormatException nfe)
						{							
						}
					}
					session.setMaxInactiveInterval(timeout);
					session.setAttribute("nickname", nickname);
					ChatRoom chatRoom = roomlist.getRoom("StartUp"); 
					nickname = nickname.toLowerCase();
					if ("m".equals(gender))
					{
						gender = "Male";
					}
					else
					{
						gender = "Female";
					}
					Chatter chatter = new Chatter(nickname, gender, new java.util.Date().getTime());
					chatRoom.addChatter(chatter);
					response.sendRedirect(contextPath+"/listrooms.jsp");

				}
			}
			catch(Exception exception)
			{
				System.out.println("Exception thrown in LoginServlet: " + exception.getMessage());
				exception.printStackTrace();
				response.sendRedirect(contextPath+"/chatError.jsp");
			}
		}
		else
		{
			response.sendRedirect(contextPath+"/chatLogin.jsp?ic=t");
		}
	}
	}


