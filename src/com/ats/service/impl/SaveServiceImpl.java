package com.ats.service.impl;
import javax.servlet.http.HttpServletRequest;

import com.ats.constant.FieldsConstants;
import com.ats.dao.impl.SaveDAOImpl;
import com.ats.model.SaveDetailsModel;
import com.ats.service.SaveService;

public class SaveServiceImpl implements SaveService{

	@Override
	public String saveDetails(HttpServletRequest request) {
		SaveDAOImpl daoService=new SaveDAOImpl();
		return daoService.saveDetails(saveDtls(request));
	}

	private SaveDetailsModel saveDtls(HttpServletRequest request) {
		SaveDetailsModel saveModel=new SaveDetailsModel();
		saveModel.setFirstName(request.getParameter(FieldsConstants.FIRSTNAME));
		saveModel.setLastName(request.getParameter(FieldsConstants.LASTNAME));
		saveModel.setUniversity(request.getParameter(FieldsConstants.UNIVERSITY));
		saveModel.setDesignation(request.getParameter(FieldsConstants.DESIGNATION));
		saveModel.setMobileNumber(request.getParameter(FieldsConstants.MOBILENUMBER));
		saveModel.setEmail(request.getParameter(FieldsConstants.EMAIL));
		saveModel.setCollegeName(request.getParameter(FieldsConstants.COLLEGENAME));
		saveModel.setCollegeCode(request.getParameter(FieldsConstants.COLLEGECODE));
		saveModel.setFirstCollege(request.getParameter(FieldsConstants.FIRSTCOLLEGE));
		saveModel.setSecondCollege(request.getParameter(FieldsConstants.SECONDCOLLEGE));
		saveModel.setThirdCollege(request.getParameter(FieldsConstants.THIRDCOLLEGE));
		saveModel.setFourthCollege(request.getParameter(FieldsConstants.FOURTHCOLLEGE));
		return saveModel;
	}

}
