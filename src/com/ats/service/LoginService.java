package com.ats.service;

import com.ats.model.LoginModel;

public interface LoginService {
	
	String validateLogin(String userName,String password);

	LoginModel getLoginDetails(String userName);
}
