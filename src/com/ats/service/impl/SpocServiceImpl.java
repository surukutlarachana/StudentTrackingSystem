package com.ats.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ats.constant.FieldsConstants;
import com.ats.dao.impl.SpocDAOImpl;
import com.ats.dao.impl.StuClgDtlsDAOImpl;
import com.ats.model.RegistrationModel;
import com.ats.model.SpocModel;
import com.ats.service.SpocService;
public class SpocServiceImpl implements SpocService{
	
	@Override
	public List<RegistrationModel> getStuDetails(String userName) {
		SpocDAOImpl spocImpl=new SpocDAOImpl();
		StuClgDtlsDAOImpl stuDtl=new StuClgDtlsDAOImpl();
		return spocImpl.getRegisterStudentDetails(stuDtl.getStudentDetails(spocImpl.getSpocDetails(userName)));
	}

	@Override
	public String verifyStudent(String studentid,String mbno,String firstName,String lastName) {
		SpocDAOImpl spocImpl=new SpocDAOImpl();
		return spocImpl.verifyStudent(studentid,mbno,firstName,lastName);
	}
	

	@Override
	public String  saveSpocDetails(HttpServletRequest request) {
		SpocDAOImpl spocImpl=new SpocDAOImpl();
		return spocImpl.saveSpocDtls(setSpocDetails(request));
		
	}
	
	@Override
	public String savePostDetails(String fullname, String description,long time, String collegeName) {
		SpocDAOImpl spocImpl=new SpocDAOImpl();
		return spocImpl.savePosts(fullname,description,time,collegeName);
	}

	
	private SpocModel setSpocDetails(HttpServletRequest request){
		SpocModel spocModel= new SpocModel();
		spocModel.setFirstName(request.getParameter(FieldsConstants.FIRSTNAME));
		spocModel.setLastName(request.getParameter(FieldsConstants.LASTNAME));
		spocModel.setCollegeName(request.getParameter(FieldsConstants.COLLEGENAME));
		spocModel.setDesignation(request.getParameter(FieldsConstants.DESIGNATION));
		spocModel.setMobileNumber(request.getParameter(FieldsConstants.MOBILENUMBER));
		spocModel.setEmail(request.getParameter(FieldsConstants.EMAIL));
		spocModel.setCollegeCode(request.getParameter(FieldsConstants.COLLEGECODE));
		return spocModel;
	}

	
}

