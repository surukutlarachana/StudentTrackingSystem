package com.ats.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ats.model.RegistrationModel;




public interface SpocService {
	List<RegistrationModel> getStuDetails(String userName);
	String verifyStudent(String studentid,String mbno,String firstName,String lastName);
	String saveSpocDetails(HttpServletRequest request);
	String savePostDetails(String fullname, String description, long time,
			String collegeName);
}
