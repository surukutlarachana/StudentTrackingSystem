package com.ats.dao;
import java.util.List;

import com.ats.model.RegistrationModel;
import com.ats.model.SpocModel;

public interface SpocDAO {

	String getSpocDetails(String userName);
	List<RegistrationModel> getRegisterStudentDetails(List<String> studentId);
	String verifyStudent(String studentid,String mbno,String fname,String lastName);
	String saveSpocDtls(SpocModel setSpocDetails);
	String savePosts(String fullname, String description,long time,String collegeName);
}
