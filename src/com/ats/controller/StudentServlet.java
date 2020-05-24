package com.ats.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.constant.FieldsConstants;
import com.ats.constant.PageConstants;
import com.ats.model.LoginModel;
import com.ats.service.impl.RegistrationServiceImpl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet(name = "Student", urlPatterns = { "/student" })
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {;
		RegistrationServiceImpl regService=new RegistrationServiceImpl();
		LoginModel model=(LoginModel)request.getSession().getAttribute("loginModel");
		request.getSession().setAttribute(FieldsConstants.DATA,regService.getRegDetails(model.getUserName()));
		RequestDispatcher dispatcher=request.getRequestDispatcher(PageConstants.STUDENT_JSP);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
