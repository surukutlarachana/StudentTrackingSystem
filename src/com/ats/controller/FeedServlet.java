package com.ats.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.model.LoginModel;
import com.ats.model.Post;
import com.ats.service.impl.LoginServiceImpl;
import com.ats.service.impl.SpocServiceImpl;

/**
 * Servlet implementation class FeedServlet
 */
@WebServlet(name = "Feeds", urlPatterns = { "/feeds" })
public class FeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LinkedList<Post> postsByTime = new LinkedList<>();
	private Map<String, LinkedList<Post>> postsByUser = new HashMap<>();
	
	private void addPost(String user, String message, long time,String collegeName){
		Post post = new Post(user, message, new Date(time),collegeName);
		postsByTime.addFirst(post);
		if(!postsByUser.containsKey(user)){
			postsByUser.put(user, new LinkedList<>());
		}
		postsByUser.get(user).addFirst(post);
	}

	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public FeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginServiceImpl serviceImpl=new LoginServiceImpl();
		SpocServiceImpl impl=new SpocServiceImpl();
		String user=(String)request.getSession().getAttribute("clguserName");
		LoginModel model=serviceImpl.getLoginDetails(user);
		if("".equals(model.getFullName())){
			request.setAttribute("title", "All Posts");
			request.setAttribute("posts", postsByTime);
		}
		else{
			request.setAttribute("title", "Posts by " + user);
			
			if(postsByUser.containsKey(model.getFullName())){
				
				request.setAttribute("posts", postsByUser.get(model.getFullName()));
			}
		}
		
		request.getRequestDispatcher("feeds.jsp").forward(request,response);
		for(Post post:postsByTime){
			impl.savePostDetails(post.getUser(),post.getMessage(),System.currentTimeMillis(),post.getCollegeName());
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		String collegeName=request.getParameter("collegeName");
		addPost(name, message, System.currentTimeMillis(),collegeName);
		response.sendRedirect("feeds");
	}

}
