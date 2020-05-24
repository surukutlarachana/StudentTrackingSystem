package com.ats.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ats.constant.FieldsConstants;
import com.ats.service.impl.RegistrationServiceImpl;
import com.ats.constant.PageConstants;
/**
 * Servlet implementation class Register
 */
@WebServlet(name = "signup", urlPatterns = { "/register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistrationServiceImpl register=new RegistrationServiceImpl();
		String status=register.save(request);
		if(status.equalsIgnoreCase(FieldsConstants.SUCCESS_STATUS)){
			response.sendRedirect(PageConstants.STUDENT_REGISTRATION);
		}else{
			response.sendRedirect(PageConstants.STUDENT_REG_FAILED);
		}
	}

}
