package com.ats.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ats.constant.FieldsConstants;
import com.ats.constant.PageConstants;
import com.ats.service.impl.UpdateServiceImpl;

/**
 * Servlet implementation class UpdateDirectorate
 */
@WebServlet(name = "UService", urlPatterns = { "/updser" })
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
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
		UpdateServiceImpl serviceImpl=new UpdateServiceImpl();
		String dtlsresp=serviceImpl.updateDetails(request);
		String []resp=dtlsresp.split(",");
		String status=resp[0];
		String role=resp[1];
		if(status.equalsIgnoreCase(FieldsConstants.SUCCESS_STATUS) && role.equalsIgnoreCase(FieldsConstants.STUDENT) ){
			response.sendRedirect(PageConstants.SUDENT_SERVLET);
		}else if(status.equalsIgnoreCase(FieldsConstants.SUCCESS_STATUS) && role.equalsIgnoreCase(FieldsConstants.COLLEGE)){
			response.sendRedirect(PageConstants.COLLEGE_SERVLET);
		}else if(status.equalsIgnoreCase(FieldsConstants.SUCCESS_STATUS) && role.equalsIgnoreCase(FieldsConstants.DIRECTORATE)){
			response.sendRedirect(PageConstants.DIRECTORATE_PAGE);
		}else{
			response.sendRedirect(PageConstants.UPDATE_FAILED);
		}
	}

}
