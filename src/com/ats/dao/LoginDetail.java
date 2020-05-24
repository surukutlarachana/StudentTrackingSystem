package com.ats.dao;

import com.ats.model.LoginModel;

public interface LoginDetail {

	LoginModel getLoginDetail(String userName);
	LoginModel getLoginDetail(String userName,String pwd);
	
}
