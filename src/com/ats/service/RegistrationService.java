package com.ats.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ats.model.RegistrationModel;

public interface RegistrationService {

	String save(HttpServletRequest request);

	List<RegistrationModel> getRegDetails(String studentId);
	
	String updateStudDtls(HttpServletRequest request);
}
