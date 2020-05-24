package com.ats.service.impl;

import com.ats.dao.impl.LoginDetailsImpl;
import com.ats.model.LoginModel;
import com.ats.service.LoginService;
public class LoginServiceImpl implements LoginService {

	@Override
	public String validateLogin(String userName, String password) {
		LoginDetailsImpl login=new LoginDetailsImpl();
		LoginModel model=new LoginModel();
		String response=null;
		model=login.getLoginDetail(userName,password);
		if(model.getUserName().equalsIgnoreCase(userName) 
				&& model.getPwd().equalsIgnoreCase(password)
				&& model.getError()== null){
			response= model.getUseRoles();
		}else{
			response=model.getError();
		}
		return response;
	}
	
	@Override

	public LoginModel getLoginDetails(String userName) {
		LoginDetailsImpl daoImpl=new LoginDetailsImpl();
		return daoImpl.getLoginDetail(userName);
	}

}
