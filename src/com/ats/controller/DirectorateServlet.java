package com.ats.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.constant.*;
import com.ats.service.impl.*;
/**
 * Servlet implementation class DirectorateServlet
 */
@WebServlet(name = "Directorate", urlPatterns = { "/directorate" })
public class DirectorateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DirectorateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setAttribute("ldata", request.getSession().getAttribute("ldetails"));
		if(request.getSession().getAttribute("sdetails") != null){
		session.setAttribute("sdata", request.getSession().getAttribute("sdetails"));
		}
		request.getRequestDispatcher(PageConstants.DIRECTORATE_PAGE).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SearchServiceImpl service=new SearchServiceImpl();
		LoginServiceImpl serviceImpl=new LoginServiceImpl();
		HttpSession session=request.getSession();
		session.setAttribute("ldetails",serviceImpl.getLoginDetails(request.getParameter(FieldsConstants.USERNAME)));
		session.setAttribute("sdetails", service.getSearchDetails(request));
		response.sendRedirect(PageConstants.DIRECTORATE_SERVLET);
		
	}

}
