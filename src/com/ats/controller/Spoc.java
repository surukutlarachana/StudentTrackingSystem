package com.ats.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.constant.FieldsConstants;
import com.ats.constant.PageConstants;
import com.ats.model.RegistrationModel;
import com.ats.service.impl.SearchServiceImpl;
import com.ats.service.impl.SpocServiceImpl;
/**
 * Servlet implementation class Spoc
 */
@WebServlet(name = "College", urlPatterns = { "/college" })
public class Spoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Spoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setAttribute("lmodel",request.getSession().getAttribute("loginModel"));
		session.setAttribute(FieldsConstants.DATA, request.getSession().getAttribute(FieldsConstants.DETAILS));
		if(request.getSession().getAttribute("srDetails")!=null){
			session.setAttribute("srData", request.getSession().getAttribute("srDetails"));
		}
		request.getRequestDispatcher(PageConstants.COLLEGE_JPS).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SpocServiceImpl spImpl=new SpocServiceImpl();
		SearchServiceImpl serviceImpl=new SearchServiceImpl();
		List<RegistrationModel>stuDetails=new ArrayList<>();
		String studentid=request.getParameter(FieldsConstants.ROLLNO);
		String mobileNumber=request.getParameter(FieldsConstants.MOBILENUMBER);
		String firstName=request.getParameter(FieldsConstants.FIRSTNAME);
		String lastName=request.getParameter(FieldsConstants.LASTNAME);
		
		String searchBtn=request.getParameter("Search");
		String verify=request.getParameter("verify");
		String status=null;
		if(studentid != null && verify !=null && !verify.isEmpty()){
			status=spImpl.verifyStudent(studentid,mobileNumber,firstName,lastName);
		}
		if(searchBtn !=null && ! searchBtn.isEmpty() ){
			stuDetails=serviceImpl.getSearchDetails(request);
		}
		
		if(!stuDetails.isEmpty()){
			HttpSession session=request.getSession();
			session.setAttribute("srDetails", stuDetails);
			session.setAttribute(FieldsConstants.DATA,spImpl.getStuDetails(session.getAttribute("clguserName").toString() ));
		}
		if((status !=null  && status.equalsIgnoreCase(FieldsConstants.SUCCESS_STATUS) )|| ! stuDetails.isEmpty()){
			response.sendRedirect(PageConstants.COLLEGE_SERVLET);
		}
		else{
			
		}
	}

}
