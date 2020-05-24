package com.ats.dao;

import java.util.List;

import com.ats.model.RegistrationModel;

public interface RegistrationDAO {
	 
	String setRegDetails(RegistrationModel model);

	List<RegistrationModel> getRegDetails(String studentId);
	
}
