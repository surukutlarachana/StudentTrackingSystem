package com.ats.service.impl;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ats.constant.FieldsConstants;
import com.ats.dao.impl.SearchDAOImpl;
import com.ats.model.RegistrationModel;
import com.ats.model.SearchModel;
import com.ats.service.SearchService;
public class SearchServiceImpl implements SearchService{

	@Override
	public List<RegistrationModel> getSearchDetails(HttpServletRequest request) {
		SearchDAOImpl searchDAO=new SearchDAOImpl();
		return searchDAO.getDetails(setSearchDetails(request));
	}
	private SearchModel setSearchDetails(HttpServletRequest request){
		SearchModel srModel=new SearchModel();
		srModel.setCollegeName(request.getParameter(FieldsConstants.COLLEGENAME));
		srModel.setStartYear(request.getParameter(FieldsConstants.STARTYEAR));
		srModel.setEndYear(request.getParameter(FieldsConstants.ENDYEAR));
		srModel.setBranch(request.getParameter(FieldsConstants.BRANCH  ));
		srModel.setCollegCode(request.getParameter(FieldsConstants.COLLEGECODE));
		return srModel;
	}

}
