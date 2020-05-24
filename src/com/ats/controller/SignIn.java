package com.ats.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.constant.FieldsConstants;
import com.ats.constant.PageConstants;
import com.ats.model.LoginModel;
import com.ats.service.impl.LoginServiceImpl;
import com.ats.service.impl.SpocServiceImpl;
/**
 * Servlet implementation class SignIn
 */
@WebServlet(name = "login", urlPatterns = { "/Login" })
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
       
    }
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginServiceImpl serviceImpl=new LoginServiceImpl();
		String userName=request.getParameter(FieldsConstants.USERNAME);
		String pwd=request.getParameter(FieldsConstants.PASSWORD);
		String roles=request.getParameter(FieldsConstants.ROLES);
		String result=null;
		SpocServiceImpl impl=new SpocServiceImpl();
		LoginModel model=serviceImpl.getLoginDetails(userName);
		HttpSession session=request.getSession();
		if(userName != null && pwd != null){
			result=serviceImpl.validateLogin(userName, pwd);
		}
		else{
			request.setAttribute("Message", result);
            getServletContext().getRequestDispatcher("/Result.jsp").forward(
                    request, response);
		}
		
		if(model.getError()!= null){
			request.setAttribute("Message", model.getError());
            getServletContext().getRequestDispatcher("/Result.jsp").forward(
                    request, response);
		}else{
		if( result != null && result.equalsIgnoreCase(FieldsConstants.ADMIN) && roles.equalsIgnoreCase(FieldsConstants.ADMIN)){
			session.setAttribute("fullname", model.getFullName());
			response.sendRedirect(PageConstants.ADMIN_PAGE);
		}else if(result != null && result.equalsIgnoreCase(FieldsConstants.STUDENT) && roles.equalsIgnoreCase(FieldsConstants.STUDENT)){
			session.setAttribute("fullname",model.getFullName());
			session.setAttribute("loginModel",model);
			response.sendRedirect(PageConstants.SUDENT_SERVLET);
		}else if(result != null && result.equalsIgnoreCase(FieldsConstants.COLLEGE) && roles.equalsIgnoreCase(FieldsConstants.COLLEGE)){
			session.setAttribute("clguserName", request.getParameter(FieldsConstants.USERNAME));
			session.setAttribute("loginModel",model);
			session.setAttribute(FieldsConstants.DETAILS, impl.getStuDetails(userName));
			response.sendRedirect(PageConstants.COLLEGE_SERVLET);
		}else if(result != null && result.equalsIgnoreCase(FieldsConstants.DIRECTORATE) && roles.equalsIgnoreCase(FieldsConstants.DIRECTORATE)){
			session.setAttribute("ldetails", serviceImpl.getLoginDetails(userName));
			response.sendRedirect(PageConstants.DIRECTORATE_SERVLET);
			
		}
	}
}
	
	

}
