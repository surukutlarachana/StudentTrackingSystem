package com.ats.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ats.dao.impl.RegistrationDAOImpl;
import com.ats.model.RegistrationModel;
import com.ats.service.RegistrationService;
import com.ats.constant.FieldsConstants;
public class RegistrationServiceImpl implements RegistrationService {

	@Override
	public String save(HttpServletRequest request) {
		String message=null;
		RegistrationDAOImpl regImpl=new RegistrationDAOImpl();
		message=regImpl.setRegDetails(setValues(request));
		return message;
	}
	
	private RegistrationModel setValues(HttpServletRequest request){
		RegistrationModel rmodel= new RegistrationModel();
		rmodel.setRollno(request.getParameter(FieldsConstants.ROLLNO));
		rmodel.setFirstName(request.getParameter(FieldsConstants.FIRSTNAME));
		rmodel.setLastName(request.getParameter(FieldsConstants.LASTNAME));
		rmodel.setDob(request.getParameter(FieldsConstants.DOB));
		rmodel.setEmail(request.getParameter(FieldsConstants.EMAIL));
		rmodel.setMobileNumber(request.getParameter(FieldsConstants.MOBILENUMBER));
		rmodel.setCollegeName(request.getParameter(FieldsConstants.COLLEGENAME));
		rmodel.setBranch(request.getParameter(FieldsConstants.BRANCH));
		rmodel.setCourse(request.getParameter(FieldsConstants.COURSE));
		rmodel.setStartYear(request.getParameter(FieldsConstants.STARTYEAR));
		rmodel.setEndYear(request.getParameter(FieldsConstants.ENDYEAR));
		rmodel.setExcelling(request.getParameter(FieldsConstants.EXCELLING));
		rmodel.setCollegeCode(request.getParameter(FieldsConstants.COLLEGECODE));
		rmodel.setVerified(String.valueOf(FieldsConstants.FALSE));
		
		return rmodel;
		
	}
	
	@Override
	public List<RegistrationModel> getRegDetails(String studentId) {
		RegistrationDAOImpl daoService=new RegistrationDAOImpl();
		return daoService.getRegDetails(studentId);
		
	}

	@Override
	public String updateStudDtls(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
