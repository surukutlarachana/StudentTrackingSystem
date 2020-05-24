package com.ats.service.impl;
import javax.servlet.http.HttpServletRequest;
import com.ats.model.UpdateModel;
import com.ats.service.UpdateService;
import com.ats.constant.FieldsConstants;
import com.ats.dao.impl.UpdateDAOImpl;

public class UpdateServiceImpl implements UpdateService {

	@Override
	public String updateDetails(HttpServletRequest request) {
		UpdateDAOImpl daoService=new UpdateDAOImpl();
		return daoService.updateDtls(update(request));
	}
	
	private UpdateModel update(HttpServletRequest request){
		UpdateModel upd=new UpdateModel();
		upd.setUserName(request.getParameter(FieldsConstants.USERNAME));
		upd.setPwd(request.getParameter(FieldsConstants.PASSWORD));
		upd.setEmail(request.getParameter(FieldsConstants.EMAIL));
		upd.setMobileNumber(request.getParameter(FieldsConstants.MOBILENUMBER));
		upd.setExcelling(request.getParameter(FieldsConstants.EXCELLING));
		return upd;
	}

}
