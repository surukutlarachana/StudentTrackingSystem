package com.ats.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ats.service.impl.*;
import com.ats.constant.*;

/**
 * Servlet implementation class SaveDetailsServlet
 */
@WebServlet(name = "SaveServlet", urlPatterns = { "/save" })
public class SaveDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveDetailsServlet() {
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
		SaveServiceImpl saveService=new SaveServiceImpl();
		String status=null;
		status=saveService.saveDetails(request);
		if(status.equalsIgnoreCase(FieldsConstants.SUCCESS_STATUS)){
			response.sendRedirect(PageConstants.ADMIN_PAGE);
		}else{
			response.sendRedirect(PageConstants.LOGIN_ERROR_PAGE);
		}
		
	}

}
